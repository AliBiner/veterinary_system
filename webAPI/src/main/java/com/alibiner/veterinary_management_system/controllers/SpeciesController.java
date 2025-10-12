package com.alibiner.veterinary_management_system.controllers;

import com.alibiner.config.modelMapper.IModelMapperService;
import com.alibiner.dtos.request.species.controller.SpeciesCreateRequestDto;
import com.alibiner.dtos.request.species.controller.SpeciesUpdateRequestDto;
import com.alibiner.dtos.request.species.service.SpeciesRequestDto;
import com.alibiner.dtos.response.species.SpeciesResponseDto;
import com.alibiner.interfaces.species.ISpeciesService;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/species")
public class SpeciesController {

    private final ISpeciesService speciesService;
    private final IModelMapperService modelMapperService;

    public SpeciesController(ISpeciesService speciesService, IModelMapperService modelMapperService) {
        this.speciesService = speciesService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping
    public ResponseEntity<Result<SpeciesResponseDto>> create(@Valid @RequestBody SpeciesCreateRequestDto requestDto) {
        SpeciesRequestDto mappedRequest = modelMapperService.forRequest().map(requestDto, SpeciesRequestDto.class);
        SpeciesResponseDto result = speciesService.create(mappedRequest);
        return ResponseEntity.ok(Result.ok(result));
    }

    @PutMapping
    public ResponseEntity<Result<SpeciesResponseDto>> update(@Valid @RequestBody SpeciesUpdateRequestDto requestDto) {
        SpeciesRequestDto mappedRequest = modelMapperService.forRequest().map(requestDto, SpeciesRequestDto.class);
        SpeciesResponseDto result = speciesService.update(mappedRequest);
        return ResponseEntity.ok(Result.ok(result));
    }
}
