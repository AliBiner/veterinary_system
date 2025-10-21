package com.alibiner.services.appointment;

import java.util.*;
import com.alibiner.dtos.request.appointment.service.AppointmentRequestDto;
import com.alibiner.dtos.response.appointment.service.AppointmentDetailResponseDto;
import com.alibiner.dtos.response.appointment.service.AppointmentResponseDto;
import com.alibiner.dtos.response.appointment.service.GetAllAppointmentResponseDto;
import com.alibiner.entities.Animal;
import com.alibiner.entities.Appointment;
import com.alibiner.entities.User;
import com.alibiner.enums.AppointmentStatus;
import com.alibiner.errorMessages.ErrorMessages;
import com.alibiner.exceptions.NotAvailable;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.interfaces.animal.IAnimalVerificationService;
import com.alibiner.interfaces.appointment.IAppointmentService;
import com.alibiner.interfaces.appointment.IAppointmentVerificationService;
import com.alibiner.interfaces.user.doctor.IDoctorAvailabilityService;
import com.alibiner.interfaces.user.doctor.IDoctorService;
import com.alibiner.interfaces.user.doctor.IDoctorVerificationService;
import com.alibiner.mappers.service.appointment.AppointmentMapper;
import com.alibiner.repositories.AppointmentRepository;
import com.alibiner.specifications.appointment.verify.AppointmentVerifyCriteria;
import com.alibiner.specifications.appointment.verify.AppointmentVerifySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService implements IAppointmentService, IAppointmentVerificationService {

    private final IDoctorVerificationService doctorVerificationService;
    private final IAnimalVerificationService animalVerificationService;
    private final IDoctorAvailabilityService availabilityService;

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(IDoctorVerificationService doctorVerificationService, IAnimalVerificationService animalVerificationService, IDoctorService doctorService, IDoctorAvailabilityService availabilityService, AppointmentRepository appointmentRepository) {
        this.doctorVerificationService = doctorVerificationService;
        this.animalVerificationService = animalVerificationService;
        this.availabilityService = availabilityService;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void cancel(UUID id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);

        if (appointment.isEmpty())
            throw new NotFoundException(ErrorMessages.NotFoundMessages.APPOINTMENT_NOT_FOUND);

        appointment.get().setStatus(AppointmentStatus.CANCELLED);
        appointmentRepository.save(appointment.get());
    }

    @Override
    public AppointmentDetailResponseDto getById(UUID id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isEmpty())
            throw new NotFoundException(ErrorMessages.NotFoundMessages.APPOINTMENT_NOT_FOUND);

        return AppointmentMapper.toAppointmentDetailResponseDto(appointment.get());
    }

    private Appointment getByIdAsAppointment(UUID id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isEmpty())
            throw new NotFoundException(ErrorMessages.NotFoundMessages.APPOINTMENT_NOT_FOUND);
        return appointment.get();
    }

    @Override
    public Page<GetAllAppointmentResponseDto> getAll(Pageable pageable, Specification<Appointment> specification) {
        Page<Appointment> appointments = appointmentRepository.findAll(specification, pageable);
        return appointments.map(AppointmentMapper::toGetAllAppointmentResponseDto);
    }


    @Override
    public AppointmentResponseDto create(AppointmentRequestDto dto) {
        doctorVerificationService.verify(dto.getDoctorId());

        availabilityService.availabilityDoctor(dto.getDoctorId(), dto.getAppointmentDate().toLocalDate());

        availabilityAppointment(dto.getDoctorId(), dto.getAppointmentDate());

        animalVerificationService.verify(dto.getAnimalId());

        Appointment appointment = newInstance(dto);

        appointmentRepository.save(appointment);

        return AppointmentMapper.toAppointmentResponseDto(appointment);
    }



    private void availabilityAppointment(UUID doctorId, LocalDateTime appointmentDate) {
        AppointmentVerifyCriteria criteria = new AppointmentVerifyCriteria(doctorId, appointmentDate);
        AppointmentVerifySpecification specification = new AppointmentVerifySpecification(criteria);
        List<Appointment> appointments = appointmentRepository.findAll(specification);
        if (!appointments.isEmpty())
            throw new NotAvailable(NotAvailable.DOCTOR);
    }

    private Appointment newInstance(AppointmentRequestDto dto) {
        User doctor = new User();
        doctor.setId(dto.getDoctorId());

        Animal animal = new Animal();
        animal.setId(dto.getAnimalId());

        LocalDateTime startDate = calculateStartDate(dto.getAppointmentDate());
        LocalDateTime finishDate = calculateFinishDate(dto.getAppointmentDate());

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setAnimal(animal);
        appointment.setStatus(AppointmentStatus.RESERVED);
        appointment.setCompanionName(dto.getCompanionName());
        appointment.setStartDate(startDate);
        appointment.setFinishDate(finishDate);

        return appointment;
    }


    private LocalDateTime calculateStartDate(LocalDateTime appointmentDate) {
        int year = appointmentDate.getYear();
        int month = appointmentDate.getMonthValue();
        int day = appointmentDate.getDayOfMonth();
        int hour = appointmentDate.getHour();
        int minute = 0;

        return LocalDateTime.of(year, month, day, hour, minute);
    }

    private LocalDateTime calculateFinishDate(LocalDateTime appointmentDate) {
        int year = appointmentDate.getYear();
        int month = appointmentDate.getMonthValue();
        int day = appointmentDate.getDayOfMonth();
        int hour = appointmentDate.getHour();
        int minute = 59;

        return LocalDateTime.of(year, month, day, hour, minute);
    }


    @Override
    public void verify(UUID id) {
        AppointmentDetailResponseDto appointment = getById(id);
        if (appointment.getFinishDate().isBefore(LocalDateTime.now()))
            throw new NotAvailable(ErrorMessages.NotAvailableMessages.APPOINTMENT_CAN_NOT_PAST);
        if (appointment.getStatus().equals(AppointmentStatus.CANCELLED))
            throw new NotAvailable(ErrorMessages.NotAvailableMessages.APPOINTMENT_CANCELLED);
    }

    @Override
    public Appointment verifyAndGet(UUID id) {
        Appointment appointment = getByIdAsAppointment(id);
        if (appointment.getFinishDate().isBefore(LocalDateTime.now()))
            throw new NotAvailable(ErrorMessages.NotAvailableMessages.APPOINTMENT_CAN_NOT_PAST);
        if (appointment.getStatus().equals(AppointmentStatus.CANCELLED))
            throw new NotAvailable(ErrorMessages.NotAvailableMessages.APPOINTMENT_CANCELLED);
        return appointment;
    }

}
