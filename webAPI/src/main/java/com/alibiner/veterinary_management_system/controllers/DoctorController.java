package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.dtos.request.user.UserRequestDto;
import com.alibiner.dtos.request.user.UserRequestFactory;
import com.alibiner.dtos.request.user.customer.controller.CustomerCreateRequestDto;
import com.alibiner.dtos.request.user.customer.controller.CustomerUpdateRequestDto;
import com.alibiner.dtos.response.user.UserResponseDto;
import com.alibiner.enums.UserType;
import com.alibiner.interfaces.user.IUserService;
import com.alibiner.specifications.user.UserSearchCriteria;
import com.alibiner.specifications.user.UserSpecification;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
@Validated
public class DoctorController {

    private final static UserType userType = UserType.DOCTOR;
    private final IUserService userService;

    public DoctorController(IUserService userService) {
        this.userService = userService;
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
}
