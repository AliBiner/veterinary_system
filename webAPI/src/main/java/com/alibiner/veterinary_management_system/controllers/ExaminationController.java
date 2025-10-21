package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.dtos.request.examination.service.ExaminationRequestDto;
import com.alibiner.dtos.response.examination.service.ExaminationResponseDto;
import com.alibiner.entities.Examination;
import com.alibiner.errorMessages.ErrorMessages;
import com.alibiner.interfaces.examination.IExaminationService;
import com.alibiner.specifications.examination.search.ExaminationSearchCriteria;
import com.alibiner.specifications.examination.search.ExaminationSearchSpecification;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/examinations")
public class ExaminationController {
    private final IExaminationService examinationService;

    public ExaminationController(IExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @PostMapping
    public ResponseEntity<Result<ExaminationResponseDto>> create(@Valid @RequestBody ExaminationRequestDto requestDto) {
        ExaminationResponseDto responseDto = examinationService.create(requestDto);
        return ResponseEntity.ok(Result.ok(responseDto));
    }

    @PutMapping
    public ResponseEntity<Result<ExaminationResponseDto>> update(@Valid @RequestBody ExaminationRequestDto request) {
        ExaminationResponseDto result = examinationService.update(request);
        return ResponseEntity.ok(Result.ok(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<ExaminationResponseDto>> getById(@PathVariable(name = "id") UUID id) {
        ExaminationResponseDto result = examinationService.getById(id);
        return ResponseEntity.ok(Result.ok(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") UUID id) {
        examinationService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<Result<Page<ExaminationResponseDto>>> getAll(
            @RequestParam(name = "animal-id", required = false) UUID animalId,
            @RequestParam(name = "min-examination-date", required = false) @FutureOrPresent(message = ErrorMessages.ValidationMessages.MIN_DATE_MUST_FUTURE) LocalDate minExaminationDate,
            @RequestParam(name = "max-examination-date", required = false) @FutureOrPresent(message = ErrorMessages.ValidationMessages.MAX_DATE_MUST_FUTURE) LocalDate maxExaminationDate,
            @RequestParam(name = "min-vaccine-flexible-cycle-date", required = false) @FutureOrPresent(message = ErrorMessages.ValidationMessages.MIN_DATE_MUST_FUTURE) LocalDate minVaccineFlexibleCycleDate,
            @RequestParam(name = "max-vaccine-flexible-cycle-date", required = false) @FutureOrPresent(message = ErrorMessages.ValidationMessages.MAX_DATE_MUST_FUTURE) LocalDate maxVaccineFlexibleCycleDate,
            Pageable pageable
    ) {
        if (minExaminationDate != null && maxExaminationDate != null && minExaminationDate.isAfter(maxExaminationDate))
            throw new IllegalArgumentException("examination date " + ErrorMessages.ValidationMessages.MIN_DATE_GREATER_MAX_DATE);

        if (minVaccineFlexibleCycleDate != null && maxVaccineFlexibleCycleDate != null && minVaccineFlexibleCycleDate.isAfter(maxVaccineFlexibleCycleDate))
            throw new IllegalArgumentException("vaccine date " + ErrorMessages.ValidationMessages.MIN_DATE_GREATER_MAX_DATE);

        ExaminationSearchCriteria criteria = new ExaminationSearchCriteria(animalId, minExaminationDate, maxExaminationDate, minVaccineFlexibleCycleDate, maxVaccineFlexibleCycleDate);
        Specification<Examination> specification = new ExaminationSearchSpecification(criteria);

        Page<ExaminationResponseDto> result = examinationService.getAll(pageable, specification);

        return ResponseEntity.ok(Result.ok(result));
    }
}
