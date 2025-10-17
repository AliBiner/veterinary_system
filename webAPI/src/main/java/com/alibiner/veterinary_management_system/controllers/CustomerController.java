package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.dtos.request.customer.controller.CustomerCreateRequestDto;
import com.alibiner.dtos.request.customer.controller.CustomerUpdateRequestDto;
import com.alibiner.dtos.request.customer.service.CustomerRequestDto;
import com.alibiner.dtos.response.customer.CustomerResponseDto;
import com.alibiner.enums.UserType;
import com.alibiner.interfaces.user.IUserService;
import com.alibiner.specifications.user.UserSearchCriteria;
import com.alibiner.specifications.user.UserSpecification;
import com.alibiner.veterinary_management_system.mappers.controller.customer.CustomerMapper;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@Validated
public class CustomerController {

    private final IUserService userService;

    public CustomerController(@Qualifier("customerService") IUserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<Result<CustomerResponseDto>> create(@Valid @RequestBody CustomerCreateRequestDto request) {
        CustomerRequestDto mappedRequest = CustomerMapper.toCustomerRequestDto(request);

        if (userService.create(mappedRequest) instanceof CustomerResponseDto result)
            return ResponseEntity.ok(Result.ok(result));

        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping
    public ResponseEntity<Result<CustomerResponseDto>> update(@Valid @RequestBody CustomerUpdateRequestDto request) {
        System.out.println(request);
        CustomerRequestDto mappedRequest = CustomerMapper.toCustomerRequestDto(request);
        System.out.println(mappedRequest);
        if (userService.update(mappedRequest) instanceof CustomerResponseDto result) {
            return ResponseEntity.ok(Result.ok(result));
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<CustomerResponseDto>> getById(@PathVariable UUID id) {
        if (userService.getById(id) instanceof CustomerResponseDto result) {
            return ResponseEntity.ok(Result.ok(result));
        }
        return ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result<Void>> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok(Result.ok());
    }

    @GetMapping
    public ResponseEntity<Result<Page<CustomerResponseDto>>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String mail,
            Pageable pageable) {
        UserSpecification specification = new UserSpecification(
                new UserSearchCriteria(
                        name,
                        phone,
                        mail,
                        UserType.CUSTOMER
                )
        );

        Page<CustomerResponseDto> customers = userService.getAll(pageable, specification);

        return ResponseEntity.ok(Result.ok(customers));

    }
}
