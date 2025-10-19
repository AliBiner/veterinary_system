package com.alibiner.services.availableDate;

import java.util.*;
import com.alibiner.dtos.request.user.UserRequestDto;
import com.alibiner.dtos.response.availableDate.AvailableDateResponseDto;
import com.alibiner.dtos.response.user.UserResponseDto;
import com.alibiner.entities.AvailableDate;
import com.alibiner.entities.User;
import com.alibiner.enums.UserType;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.interfaces.availableDate.IAvailableDateService;
import com.alibiner.interfaces.user.IUserService;
import com.alibiner.mappers.service.availableDate.AvailableDateMapper;
import com.alibiner.mappers.service.customer.UserMapper;
import com.alibiner.repositories.AvailableDateRepository;
import com.alibiner.specifications.user.UserSpecification;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.*;

@Service
public class AvailableDateService implements IAvailableDateService {

    private final IUserService<UserRequestDto, UserResponseDto, UserSpecification> userService;
    private final UserType canOwnerAnAvailableDate = UserType.DOCTOR;

    private final AvailableDateRepository availableDateRepository;

    public AvailableDateService(IUserService<UserRequestDto, UserResponseDto, UserSpecification> userService, AvailableDateRepository availableDateRepository) {
        this.userService = userService;
        this.availableDateRepository = availableDateRepository;
    }


    @Override
    public void create(UUID doctorId, HashSet<LocalDate> dateList) {
        UserResponseDto doctorResponseDto = userService.getById(doctorId, canOwnerAnAvailableDate);//if not found, throw exception

        User doctor = UserMapper.toUser(doctorResponseDto);

        List<AvailableDate> insertable = dateList.stream().filter(date -> date.isAfter(LocalDate.now())).map(date -> {
            AvailableDate insertableDate = new AvailableDate();
            insertableDate.setAvailableDate(date);
            insertableDate.setUser(doctor);
            return insertableDate;
        }).toList();

        for (AvailableDate availableDate : insertable) {
            try {
                availableDateRepository.updateOrInsert(availableDate);
            } catch (DataIntegrityViolationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void update(UUID doctorId, HashMap<UUID, LocalDate> dtoList) {
        UserResponseDto userResponseDto = userService.getById(doctorId, canOwnerAnAvailableDate);//if not found, throw exception

        User user = UserMapper.toUser(userResponseDto);

        HashMap<UUID, LocalDate> filteredDates =
                dtoList
                        .entrySet()
                        .stream()
                        .filter(key -> dtoList.get(key.getKey()).isAfter(LocalDate.now()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (v1, v2) -> {
                                    throw new IllegalStateException();
                                },
                                HashMap::new)  // TreeMap::new
                        );

        if (filteredDates.isEmpty())
            throw new NotFoundException("No valid date available to save.");

        List<AvailableDate> availableDateList = availableDateRepository.findAllByIdInAndUser(filteredDates.keySet(),
                user);

        if (availableDateList.isEmpty())
            throw new NotFoundException("Not found any available date for update");

        for (AvailableDate availableDate : availableDateList) {
            for (UUID key : dtoList.keySet()) {
                if (availableDate.getId().equals(key)) {
                    availableDate.setAvailableDate(dtoList.get(key));
                    break;
                }
            }
        }

        for (AvailableDate availableDate : availableDateList) {
            try {
                availableDateRepository.updateOrInsert(availableDate);
            } catch (DataIntegrityViolationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void delete(UUID id) {
        Optional<AvailableDate> availableDate = availableDateRepository.findById(id);
        if (availableDate.isEmpty())
            throw new NotFoundException("available date not found");
        availableDateRepository.delete(availableDate.get());
    }

    @Override
    public void deleteAll(HashSet<UUID> uuids) {
        uuids.stream().anyMatch(id -> {
            if (id == null)
                throw new IllegalArgumentException("Id can not be null");
            return false;
        });

        availableDateRepository.deleteAllById(uuids);
    }

//    @Override
//    public AvailableDateResponseDto getById(UUID id) {
//        return null;
//    }

    @Override
    public Page<AvailableDateResponseDto> getAll(Pageable pageable, Specification<AvailableDate> specification) {
        return availableDateRepository.findAll(specification, pageable).map(AvailableDateMapper::toAvailableDateResponseDto);
    }
}
