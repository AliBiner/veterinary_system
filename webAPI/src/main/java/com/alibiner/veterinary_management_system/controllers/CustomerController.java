package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.dtos.request.customer.controller.CustomerCreateRequestDto;
import com.alibiner.dtos.request.customer.service.CustomerRequestDto;
import com.alibiner.dtos.response.customer.CustomerResponseDto;
import com.alibiner.interfaces.user.IUserService;
import com.alibiner.veterinary_management_system.mappers.controller.customer.CustomerMapper;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@Validated
public class CustomerController {


    private final IUserService userService;

    private final CustomerMapper customerMapper;

    public CustomerController(@Qualifier("customerService") IUserService userService) {
        this.userService = userService;
        customerMapper = new CustomerMapper();
    }


    @PostMapping
    public ResponseEntity<Result<CustomerResponseDto>> create(@Valid @RequestBody CustomerCreateRequestDto request) {
        CustomerRequestDto mappedRequest = customerMapper.toCustomerRequestDto(request);

        if (userService.create(mappedRequest) instanceof CustomerResponseDto result)
            return ResponseEntity.ok(Result.ok(result));

        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<CustomerResponseDto>> getById(@PathVariable UUID id) {
        if (userService.getById(id) instanceof CustomerResponseDto result) {
            return ResponseEntity.ok(Result.ok(result));
        }
        return ResponseEntity.badRequest().body(null);
    }
}
