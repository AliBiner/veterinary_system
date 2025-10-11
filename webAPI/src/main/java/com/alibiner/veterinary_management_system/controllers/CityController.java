package com.alibiner.veterinary_management_system.controllers;

import com.alibiner.config.modelMapper.IModelMapperService;
import com.alibiner.dtos.request.city.controller.CityCreateRequestDto;
import com.alibiner.dtos.request.city.controller.CityUpdateRequestDto;
import com.alibiner.dtos.request.city.service.CityRequestDto;
import com.alibiner.dtos.response.city.CityResponseDto;
import com.alibiner.interfaces.city.ICityService;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
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

    @PostMapping("/")
    public ResponseEntity<Result<CityResponseDto>> create(@Valid @RequestBody(required = false) CityCreateRequestDto request) {
        CityRequestDto serviceRequest = modelMapperService.forRequest().map(request, CityRequestDto.class);
        CityResponseDto result = cityService.create(serviceRequest);
        return ResponseEntity.ok(Result.ok(result));
    }

    @PutMapping("/")
    public ResponseEntity<Result<CityResponseDto>> update(@Valid @RequestBody(required = false) CityUpdateRequestDto request) {
        CityRequestDto serviceRequest = modelMapperService.forRequest().map(request, CityRequestDto.class);
        CityResponseDto result = cityService.update(serviceRequest);
        return ResponseEntity.ok(Result.ok(result));
    }

    @DeleteMapping("/")
    public ResponseEntity<Result<Void>> delete(@Valid @RequestParam(name = "id", required = false) @Positive(message = "Can not be negative or zero") long id) {
        cityService.delete(id);
        return ResponseEntity.ok(Result.ok());
    }

    @GetMapping(value = "/")
    public ResponseEntity<Result<Page<CityResponseDto>>> getAll(Pageable pageable) {
        //todo - PagedResourcesAssembler assembler neler yapıyor
        Page<CityResponseDto> cities = cityService.getAll(pageable);
        return ResponseEntity.ok(Result.ok(cities));
    }

    @GetMapping(value = "/", params = {"id"})
    public ResponseEntity<Result<CityResponseDto>> getById(@RequestParam(required = false) long id) {
        CityResponseDto city = cityService.getById(id);
        return ResponseEntity.ok(Result.ok(city));
    }

    @GetMapping(value = "/", params = {"name"})
    public ResponseEntity<Result<Page<CityResponseDto>>> getByName(@RequestParam(required = false) String name, Pageable pageable) {
        Page<CityResponseDto> cities = cityService.getByName(name, pageable);
        return ResponseEntity.ok(Result.ok(cities));
    }


}
