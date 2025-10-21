package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.dtos.request.vaccine.service.VaccineCreateRequestDto;
import com.alibiner.dtos.request.vaccine.service.VaccineUpdateRequestDto;
import com.alibiner.dtos.response.vaccine.service.VaccineResponseDto;
import com.alibiner.interfaces.vaccine.IVaccineService;
import com.alibiner.specifications.vaccine.VaccineSearchCriteria;
import com.alibiner.specifications.vaccine.VaccineSpecification;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vaccines")
public class VaccineController {
    private final IVaccineService vaccineService;

    public VaccineController(IVaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping
    public ResponseEntity<Result<VaccineResponseDto>> create(@Valid @RequestBody VaccineCreateRequestDto request) {
        VaccineResponseDto result = vaccineService.create(request);
        return ResponseEntity.ok(Result.ok(result));
    }

    @PutMapping
    public ResponseEntity<Result<VaccineResponseDto>> update(@Valid @RequestBody VaccineUpdateRequestDto request) {
        VaccineResponseDto result = vaccineService.update(request);
        return ResponseEntity.ok(Result.ok(result));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Void> setStatus(@PathVariable(name = "id") UUID id, @Valid @RequestBody Boolean status) {
        System.out.println(status);
        vaccineService.setStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<VaccineResponseDto>> getById(@PathVariable(name = "id") UUID id) {
        VaccineResponseDto result = vaccineService.getById(id);
        return ResponseEntity.ok(Result.ok(result));
    }

    @GetMapping
    public ResponseEntity<Result<Page<VaccineResponseDto>>> getAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "status", required = false) Boolean status,
            Pageable pageable
    ) {
        VaccineSearchCriteria criteria = new VaccineSearchCriteria(name, description, code, status);
        VaccineSpecification specification = new VaccineSpecification(criteria);

        Page<VaccineResponseDto> result = vaccineService.getAll(pageable, specification);
        return ResponseEntity.ok(Result.ok(result));
    }

}
