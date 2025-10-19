package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.dtos.request.user.UserRequestDto;
import com.alibiner.dtos.request.user.UserRequestFactory;
import com.alibiner.dtos.request.user.customer.controller.CustomerCreateRequestDto;
import com.alibiner.dtos.request.user.customer.controller.CustomerUpdateRequestDto;
import com.alibiner.dtos.response.availableDate.AvailableDateResponseDto;
import com.alibiner.dtos.response.user.UserResponseDto;
import com.alibiner.enums.UserType;
import com.alibiner.errorMessages.ErrorMessages;
import com.alibiner.interfaces.user.IUserService;
import com.alibiner.interfaces.user.doctor.IDoctorService;
import com.alibiner.specifications.availableDate.search.AvailableDateSearchCriteria;
import com.alibiner.specifications.availableDate.search.AvailableDateSpecification;
import com.alibiner.specifications.user.UserSearchCriteria;
import com.alibiner.specifications.user.UserSpecification;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/doctors")
@Validated
public class DoctorController {

    private final static UserType userType = UserType.DOCTOR;
    private final IUserService<UserRequestDto, UserResponseDto, UserSpecification> userService;
    private final IDoctorService doctorService;


    public DoctorController(IUserService<UserRequestDto, UserResponseDto, UserSpecification> userService, IDoctorService doctorService) {
        this.userService = userService;
        this.doctorService = doctorService;
    }


    @PostMapping
    public ResponseEntity<Result<UserResponseDto>> create(@Valid @RequestBody CustomerCreateRequestDto request) {
        UserRequestDto mappedRequest = UserRequestFactory.newInstance(userType, null, request.getName(),
                request.getPhone(), request.getMail(), request.getAddress(), request.getCityID());

        if (userService.create(mappedRequest) instanceof UserResponseDto result)
            return ResponseEntity.ok(Result.ok(result));

        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping
    public ResponseEntity<Result<UserResponseDto>> update(@Valid @RequestBody CustomerUpdateRequestDto request) {
        UserRequestDto mappedRequest = UserRequestFactory.newInstance(userType, request.getId(), request.getName(), request.getPhone(),
                request.getMail(), request.getAddress(), request.getCityId());

        if (userService.update(mappedRequest) instanceof UserResponseDto result) {
            return ResponseEntity.ok(Result.ok(result));
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<UserResponseDto>> getById(@PathVariable UUID id) {
        if (userService.getById(id, userType) instanceof UserResponseDto result) {
            return ResponseEntity.ok(Result.ok(result));
        }
        return ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result<Void>> delete(@PathVariable UUID id) {
        userService.delete(id, userType);
        return ResponseEntity.ok(Result.ok());
    }

    @GetMapping
    public ResponseEntity<Result<Page<UserResponseDto>>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String mail,
            Pageable pageable) {
        UserSpecification specification = new UserSpecification(
                new UserSearchCriteria(
                        name,
                        phone,
                        mail,
                        userType
                )
        );

        Page<UserResponseDto> customers = userService.getAll(pageable, specification);

        return ResponseEntity.ok(Result.ok(customers));

    }

    @GetMapping("/{id}/available-dates")
    public ResponseEntity<Result<Page<AvailableDateResponseDto>>> getAllAvailableDateByDoctorId(
            @PathVariable(name = "id") UUID id,
            @RequestParam(name = "min-date", required = false) @FutureOrPresent(message = ErrorMessages.ValidationMessages.MIN_DATE_MUST_FUTURE) LocalDate minDate,
            @RequestParam(name = "max-date", required = false) @FutureOrPresent(message = ErrorMessages.ValidationMessages.MAX_DATE_MUST_FUTURE) LocalDate maxDate,
            Pageable pageable
    ) {
        if (minDate != null && maxDate != null && minDate.isAfter(maxDate))
            throw new IllegalArgumentException(ErrorMessages.ValidationMessages.MIN_DATE_GREATER_MAX_DATE);
        AvailableDateSpecification spec = new AvailableDateSpecification(new AvailableDateSearchCriteria(id, minDate,
                maxDate));
        System.out.println(spec);
        Page<AvailableDateResponseDto> result = doctorService.getAllAvailableDate(id, spec, pageable);
        return ResponseEntity.ok(Result.ok(result));
    }
}
