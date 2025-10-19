package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.config.modelMapper.IModelMapperService;
import com.alibiner.dtos.request.city.controller.CityCreateRequestDto;
import com.alibiner.dtos.request.city.controller.CityUpdateRequestDto;
import com.alibiner.dtos.request.city.service.CityRequestDto;
import com.alibiner.dtos.response.city.CityResponseDto;
import com.alibiner.interfaces.city.ICityService;
import com.alibiner.specifications.city.CitySearchCriteria;
import com.alibiner.specifications.city.CitySpecification;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/cities")
public class CityController {
    private final ICityService cityService;
    private final IModelMapperService modelMapperService;

    public CityController(ICityService cityService, IModelMapperService modelMapperService) {
        this.cityService = cityService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping
    public ResponseEntity<Result<CityResponseDto>> create(@Valid @RequestBody CityCreateRequestDto request) {
        CityRequestDto serviceRequest = modelMapperService.forRequest().map(request, CityRequestDto.class);
        CityResponseDto result = cityService.create(serviceRequest);
        return ResponseEntity.ok(Result.ok(result));
    }

    @PutMapping
    public ResponseEntity<Result<CityResponseDto>> update(@Valid @RequestBody CityUpdateRequestDto request) {
        CityRequestDto serviceRequest = modelMapperService.forRequest().map(request, CityRequestDto.class);
        CityResponseDto result = cityService.update(serviceRequest);
        return ResponseEntity.ok(Result.ok(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result<Void>> delete(
            @Valid
            @PathVariable
            UUID id) {
        cityService.delete(id);
        return ResponseEntity.ok(Result.ok());
    }

    @GetMapping
    public ResponseEntity<Result<Page<CityResponseDto>>> getAll(@RequestParam(required = false, name = "name") String name, Pageable pageable) {
        CitySpecification specification = new CitySpecification(new CitySearchCriteria(name));
        Page<CityResponseDto> cities = cityService.getAll(pageable, specification);
        return ResponseEntity.ok(Result.ok(cities));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Result<CityResponseDto>> getById(
            @PathVariable
            UUID id) {
        CityResponseDto city = cityService.getById(id);
        return ResponseEntity.ok(Result.ok(city));
    }
}
