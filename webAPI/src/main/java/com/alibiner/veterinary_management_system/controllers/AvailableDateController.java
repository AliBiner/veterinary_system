package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.dtos.response.availableDate.AvailableDateResponseDto;
import com.alibiner.entities.AvailableDate;
import com.alibiner.errorMessages.ErrorMessages;
import com.alibiner.interfaces.availableDate.IAvailableDateService;
import com.alibiner.specifications.availableDate.search.AvailableDateSearchCriteria;
import com.alibiner.specifications.availableDate.search.AvailableDateSpecification;
import com.alibiner.veterinary_management_system.constants.ConstantValues;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/v1/available-dates")
@Validated
public class AvailableDateController {


    private final IAvailableDateService availableDateService;

    public AvailableDateController(IAvailableDateService availableDateService) {
        this.availableDateService = availableDateService;

    }


    @PostMapping("/{doctor-id}")
    public ResponseEntity<Result<Void>> create(@PathVariable(name = "doctor-id") UUID id,
                                               @RequestBody @Size(min = 1, max = ConstantValues.MAX_INSERT_UPDATE_SIZE) HashSet<LocalDate> dates) {
        availableDateService.create(id, dates);
        return ResponseEntity.ok(Result.ok());
    }

    @PutMapping("/{doctor-id}")
    public ResponseEntity<Result<Void>> update(@PathVariable(name = "doctor-id") UUID id,
                                               @RequestBody @Size(min = 1, max = ConstantValues.MAX_INSERT_UPDATE_SIZE) HashMap<UUID,
                                                       LocalDate> dates) {
        availableDateService.update(id, dates);
        return ResponseEntity.ok(Result.ok());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") UUID id) {
        availableDateService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll(@RequestBody @Size(min = 1, max = ConstantValues.MAX_DELETE_SIZE) HashSet<UUID> uuids) {
        availableDateService.deleteAll(uuids);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Result<Page<AvailableDateResponseDto>>> getAllActive(
            @RequestParam(name = "min-date", required = false) @FutureOrPresent(message = ErrorMessages.ValidationMessages.MIN_DATE_MUST_FUTURE) LocalDate minDate,
            @RequestParam(name = "max-date", required = false) @FutureOrPresent(message = ErrorMessages.ValidationMessages.MAX_DATE_MUST_FUTURE) LocalDate maxDate,
            Pageable pageable) {
        if (minDate != null && maxDate != null && minDate.isAfter(maxDate))
            throw new IllegalArgumentException(ErrorMessages.ValidationMessages.MIN_DATE_GREATER_MAX_DATE);


        Specification<AvailableDate> specification = new AvailableDateSpecification(new AvailableDateSearchCriteria(minDate, maxDate));

        Page<AvailableDateResponseDto> result = availableDateService.getAll(pageable, specification);
        return ResponseEntity.ok(Result.ok(result));
    }
}
