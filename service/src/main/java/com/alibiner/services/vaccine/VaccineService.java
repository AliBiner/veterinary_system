package com.alibiner.services.vaccine;


import java.util.*;
import com.alibiner.dtos.request.vaccine.service.VaccineBaseRequestDto;
import com.alibiner.dtos.request.vaccine.service.VaccineCreateRequestDto;
import com.alibiner.dtos.request.vaccine.service.VaccineUpdateRequestDto;
import com.alibiner.dtos.response.vaccine.service.VaccineResponseDto;
import com.alibiner.entities.Vaccine;
import com.alibiner.errorMessages.ErrorMessages;
import com.alibiner.exceptions.AlreadyExistException;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.exceptions.NotSupportTypeException;
import com.alibiner.interfaces.vaccine.IVaccineService;
import com.alibiner.mappers.service.vaccine.VaccineMapper;
import com.alibiner.repositories.VaccineRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class VaccineService implements IVaccineService {
    private final VaccineRepository vaccineRepository;

    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public VaccineResponseDto create(@Valid VaccineBaseRequestDto dto) {
        if (dto instanceof VaccineCreateRequestDto requestDto) {
            Optional<Vaccine> vaccineOptional = vaccineRepository.findByCode(requestDto.getCode());
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
}
