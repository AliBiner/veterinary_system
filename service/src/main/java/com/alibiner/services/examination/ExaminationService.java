package com.alibiner.services.examination;


import java.util.*;
import com.alibiner.dtos.request.examination.service.ExaminationRequestDto;
import com.alibiner.dtos.response.examination.service.ExaminationResponseDto;
import com.alibiner.entities.Appointment;
import com.alibiner.entities.Examination;
import com.alibiner.entities.Vaccine;
import com.alibiner.errorMessages.ErrorMessages;
import com.alibiner.exceptions.NotAvailable;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.exceptions.UnexceptedValueException;
import com.alibiner.interfaces.appointment.IAppointmentService;
import com.alibiner.interfaces.appointment.IAppointmentVerificationService;
import com.alibiner.interfaces.examination.IExaminationService;
import com.alibiner.interfaces.vaccine.IVaccineCalculateService;
import com.alibiner.interfaces.vaccine.IVaccineVerificationService;
import com.alibiner.mappers.service.examination.ExaminationMapper;
import com.alibiner.repositories.ExaminationRepository;
import com.alibiner.specifications.examination.verify.ExaminationVerifyCriteria;
import com.alibiner.specifications.examination.verify.ExaminationVerifySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExaminationService implements IExaminationService {

    private final ExaminationRepository examinationRepository;
    private final IVaccineVerificationService vaccineVerificationService;
    private final IVaccineCalculateService vaccineCalculateService;
    private final IAppointmentVerificationService appointmentVerificationService;

    public ExaminationService(ExaminationRepository examinationRepository, IVaccineVerificationService vaccineVerificationService, IVaccineCalculateService vaccineCalculateService, IAppointmentService appointmentService, IAppointmentVerificationService appointmentVerificationService) {
        this.examinationRepository = examinationRepository;
        this.vaccineVerificationService = vaccineVerificationService;
        this.vaccineCalculateService = vaccineCalculateService;

        this.appointmentVerificationService = appointmentVerificationService;
    }

    @Override
    public ExaminationResponseDto create(ExaminationRequestDto dto) {
        Appointment appointment = appointmentVerificationService.verifyAndGet(dto.getAppointmentId());

        Vaccine vaccine = vaccineVerificationService.verify(dto.getVaccineId());

        verifyExaminationByAnimalAndVaccine(null, appointment.getAnimal().getId(), vaccine.getId());

        List<LocalDate> vaccineCycleDates = vaccineCalculateService.calculateCycleDate(vaccine);

        Examination examination = newInstance(dto, vaccineCycleDates);

        examinationRepository.save(examination);

        return ExaminationMapper.toExaminationResponseDto(examination);
    }

    @Override
    public ExaminationResponseDto update(ExaminationRequestDto dto) {
        Examination examination = getByIdAsExamination(dto.getId());

        updateAppointment(examination, dto.getAppointmentId());

        updateVaccine(examination, dto.getVaccineId());


        examinationRepository.save(examination);
        return ExaminationMapper.toExaminationDetailResponseDto(examination);
    }


    @Override
    public void delete(UUID id) {
        Examination examination = getByIdAsExamination(id);
        examinationRepository.delete(examination);
    }

    @Override
    public ExaminationResponseDto getById(UUID id) {
        if (id == null)
            throw new IllegalArgumentException("Id can not be null");

        Optional<Examination> examination = examinationRepository.findById(id);
        if (examination.isEmpty())
            throw new NotFoundException(ErrorMessages.NotFoundMessages.EXAMINATION_NOT_FOUND);

        return ExaminationMapper.toExaminationDetailResponseDto(examination.get());
    }

    private Examination getByIdAsExamination(UUID id) {
        if (id == null)
            throw new IllegalArgumentException("Id can not be null");

        Optional<Examination> examination = examinationRepository.findById(id);
        if (examination.isEmpty())
            throw new NotFoundException(ErrorMessages.NotFoundMessages.EXAMINATION_NOT_FOUND);

        return examination.get();
    }

    @Override
    public Page<ExaminationResponseDto> getAll(Pageable pageable, Specification<Examination> specification) {
        Page<Examination> result = examinationRepository.findAll(specification, pageable);
        return result.map(ExaminationMapper::toExaminationDetailResponseDto);
    }

    private Examination newInstance(ExaminationRequestDto dto, List<LocalDate> vaccineCycleDates) {

        Appointment appointment = new Appointment();
        appointment.setId(dto.getAppointmentId());

        Vaccine vaccine = new Vaccine();
        vaccine.setId(dto.getVaccineId());

        if (vaccineCycleDates == null)
            return new Examination(appointment, vaccine, LocalDate.now());
        else if (vaccineCycleDates.size() == 2)
            return new Examination(appointment, vaccine, LocalDate.now(), vaccineCycleDates.getFirst(), vaccineCycleDates.getLast());
        else
            throw new UnexceptedValueException("Invalid vaccine cycle dates result");
    }

    private void verifyExaminationByAnimalAndVaccine(UUID examinationID, @NonNull UUID animalId, @NonNull UUID vaccineId) {
        ExaminationVerifyCriteria criteria = new ExaminationVerifyCriteria(examinationID, animalId, vaccineId);
        Specification<Examination> specification = new ExaminationVerifySpecification(criteria);

        List<Examination> result = examinationRepository.findAll(specification);

        if (!result.isEmpty())
            throw new NotAvailable(ErrorMessages.NotAvailableMessages.EXAMINATION);
    }


    private void updateVaccine(@NonNull Examination examination, @NonNull UUID newVaccineId) {
        if (examination.getVaccine().getId().equals(newVaccineId))
            return;

        Vaccine vaccine = vaccineVerificationService.verify(newVaccineId);
        examination.setVaccine(vaccine);

        verifyExaminationByAnimalAndVaccine(examination.getId(), examination.getAppointment().getAnimal().getId(), examination.getVaccine().getId());

        List<LocalDate> vaccineCycleDates = vaccineCalculateService.calculateCycleDate(vaccine);

        if (vaccineCycleDates == null) {
            examination.setVaccineCycleDate(null);
            examination.setVaccineFlexibleDate(null);
        } else if (vaccineCycleDates.size() == 2) {
            examination.setVaccineCycleDate(vaccineCycleDates.getFirst());
            examination.setVaccineFlexibleDate(vaccineCycleDates.getLast());
        } else
            throw new UnexceptedValueException("Invalid vaccine cycle dates result");
    }

    private void updateAppointment(@NonNull Examination examination, @NonNull UUID newAppointmentId) {
        if (examination.getAppointment().getId().equals(newAppointmentId))
            return;

        Appointment appointment = appointmentVerificationService.verifyAndGet(newAppointmentId);
        examination.setAppointment(appointment);
    }
}
