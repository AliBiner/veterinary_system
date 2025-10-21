package com.alibiner.services.vaccine;


import java.util.*;
import com.alibiner.dtos.request.vaccine.service.VaccineBaseRequestDto;
import com.alibiner.dtos.request.vaccine.service.VaccineCreateRequestDto;
import com.alibiner.dtos.request.vaccine.service.VaccineUpdateRequestDto;
import com.alibiner.dtos.response.vaccine.service.VaccineResponseDto;
import com.alibiner.entities.Vaccine;
import com.alibiner.errorMessages.ErrorMessages;
import com.alibiner.exceptions.AlreadyExistException;
import com.alibiner.exceptions.NotAvailable;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.exceptions.NotSupportTypeException;
import com.alibiner.interfaces.vaccine.IVaccineCalculateService;
import com.alibiner.interfaces.vaccine.IVaccineService;
import com.alibiner.interfaces.vaccine.IVaccineVerificationService;
import com.alibiner.mappers.service.vaccine.VaccineMapper;
import com.alibiner.repositories.VaccineRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VaccineService implements IVaccineService, IVaccineVerificationService, IVaccineCalculateService {
    private final VaccineRepository vaccineRepository;

    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public VaccineResponseDto create(@Valid VaccineBaseRequestDto dto) {
        if (dto instanceof VaccineCreateRequestDto requestDto) {
            Optional<Vaccine> vaccineOptional = vaccineRepository.findByCode(requestDto.getCode().toUpperCase());
            if (vaccineOptional.isPresent())
                throw new AlreadyExistException(ErrorMessages.AlreadyExistMessages.VACCINE);
            Vaccine vaccine = VaccineMapper.toVaccine(requestDto);
            vaccineRepository.save(vaccine);
            return VaccineMapper.toVaccineResponseDto(vaccine);
        }
        throw new NotSupportTypeException(this.getClass().getName() + ".create() not supported The " + dto.getClass());
    }

    @Override
    public VaccineResponseDto update(VaccineBaseRequestDto dto) {
        if (dto instanceof VaccineUpdateRequestDto requestDto) {
            Vaccine vaccine = getByIdAsVaccine(requestDto.getId());

            vaccine.setName(requestDto.getName());
            vaccine.setDescription(requestDto.getDescription());
            vaccine.setVaccineCycle(requestDto.getVaccineCycle());
            vaccine.setFlexibleCycle(requestDto.getFlexibleCycle());

            vaccineRepository.save(vaccine);

            return VaccineMapper.toVaccineResponseDto(vaccine);
        }
        throw new NotSupportTypeException(this.getClass().getName() + ".update() not supported The " + dto.getClass());
    }

    @Override
    public void delete(UUID id) {
        setStatus(id, false);
    }

    @Override
    public VaccineResponseDto getById(UUID id) {
        Vaccine vaccine = getByIdAsVaccine(id);
        return VaccineMapper.toVaccineResponseDto(vaccine);
    }

    private Vaccine getByIdAsVaccine(UUID id) {
        Optional<Vaccine> vaccineOptional = vaccineRepository.findById(id);
        if (vaccineOptional.isEmpty())
            throw new NotFoundException(ErrorMessages.NotFoundMessages.VACCINE_NOT_FOUND);
        return vaccineOptional.get();
    }

    @Override
    public Page<VaccineResponseDto> getAll(Pageable pageable, Specification<Vaccine> specification) {
        Page<Vaccine> result = vaccineRepository.findAll(specification, pageable);
        return result.map(VaccineMapper::toVaccineResponseDto);
    }

    @Override
    public void setStatus(@NonNull UUID id, @NonNull Boolean status) {
        Vaccine vaccine = getByIdAsVaccine(id);
        vaccine.setActive(status);
        vaccineRepository.save(vaccine);
    }

    /**
     * @return if vaccine is one time, return null. if flexible vaccine, return two element in list. first element is
     * vaccine cycle date and second element is flexible cycle date.
     *
     */
    @Override
    public List<LocalDate> calculateCycleDate(Vaccine vaccine) {
        if (vaccine.getVaccineCycle() == 0)
            return null;


        int cycleDays = vaccine.getVaccineCycle(); //90
        int flexibleCycleDays = cycleDays - vaccine.getFlexibleCycle(); // 90 -15 = 75

        LocalDate now = LocalDate.now();
        LocalDate cycleDate = now.plusDays(cycleDays); // Now + 90
        LocalDate flexibleCycleDate = now.plusDays(flexibleCycleDays); // Now + 75

        return List.of(cycleDate, flexibleCycleDate);
    }

    @Override
    public Vaccine verify(UUID id) {
        Vaccine vaccine = getByIdAsVaccine(id);
        if (!vaccine.isActive())
            throw new NotAvailable(ErrorMessages.NotAvailableMessages.VACCINE_NOT_ACTIVE);
        return vaccine;
    }
}
