package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.config.modelMapper.IModelMapperService;
import com.alibiner.dtos.request.color.controller.ColorCreateRequestDto;
import com.alibiner.dtos.request.color.controller.ColorUpdateDto;
import com.alibiner.dtos.request.color.service.ColorRequestDto;
import com.alibiner.dtos.response.color.ColorResponseDto;
import com.alibiner.interfaces.color.IColorService;
import com.alibiner.specifications.color.ColorSearchCriteria;
import com.alibiner.specifications.color.ColorSpecification;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/colors")
public class ColorController {

    private final IModelMapperService modelMapperService;
    private final IColorService colorService;

    public ColorController(IModelMapperService modelMapperService, IColorService colorService) {
        this.modelMapperService = modelMapperService;
        this.colorService = colorService;
    }

    @PostMapping
    public ResponseEntity<Result<ColorResponseDto>> create(@Valid @RequestBody(required = false) ColorCreateRequestDto dto) {
        ColorRequestDto mapped = modelMapperService.forRequest().map(dto, ColorRequestDto.class);
        ColorResponseDto result = colorService.create(mapped);
        return ResponseEntity.ok(Result.ok(result));
    }

    @PutMapping
    public ResponseEntity<Result<ColorResponseDto>> update(@Valid @RequestBody(required = false) ColorUpdateDto request) {
        ColorRequestDto mapped = modelMapperService.forResponse().map(request, ColorRequestDto.class);
        ColorResponseDto result = colorService.update(mapped);
        return ResponseEntity.ok(Result.ok(result));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Result<Void>> delete(
            @PathVariable
            UUID id
    ) {
        colorService.delete(id);
        return ResponseEntity.ok(Result.ok());
    }

    @GetMapping
    public ResponseEntity<Result<Page<ColorResponseDto>>> getAll(
            @RequestParam(name = "name", required = false)
            String name,
            Pageable pageable) {
        ColorSpecification specification = new ColorSpecification(new ColorSearchCriteria(name));
        Page<ColorResponseDto> result = colorService.getAll(pageable, specification);
        return ResponseEntity.ok(Result.ok(result));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Result<ColorResponseDto>> getById(
            @PathVariable
            UUID id) {
        ColorResponseDto result = colorService.getById(id);
        return ResponseEntity.ok(Result.ok(result));
    }

}
