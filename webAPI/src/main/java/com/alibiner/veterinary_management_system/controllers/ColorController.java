package com.alibiner.veterinary_management_system.controllers;

import com.alibiner.config.modelMapper.IModelMapperService;
import com.alibiner.dtos.request.color.controller.ColorCreateRequestDto;
import com.alibiner.dtos.request.color.controller.ColorUpdateDto;
import com.alibiner.dtos.request.color.service.ColorRequestDto;
import com.alibiner.dtos.response.color.ColorResponseDto;
import com.alibiner.interfaces.color.IColorService;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
            @PathVariable(name = "id", required = false)
            @Min(value = 1, message = "Id not be negative or zero")
            @NotNull(message = "Id can not be null")
            Long id
    ) {
        colorService.delete(id);
        return ResponseEntity.ok(Result.ok());
    }

    @GetMapping
    public ResponseEntity<Result<Page<ColorResponseDto>>> getAll(Pageable pageable) {
        Page<ColorResponseDto> result = colorService.getAll(pageable);
        return ResponseEntity.ok(Result.ok(result));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Result<ColorResponseDto>> getById(
            @PathVariable(name = "id", required = false)
            @Positive(message = "Id can not be negative or zero")
            @NotNull(message = "Id can not be null")
            long id) {
        ColorResponseDto result = colorService.getById(id);
        return ResponseEntity.ok(Result.ok(result));
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<Result<Page<ColorResponseDto>>> getByName(
            @RequestParam(name = "name", required = false)
            String name, Pageable pageable) {
        Page<ColorResponseDto> result = colorService.getByName(name, pageable);
        return ResponseEntity.ok(Result.ok(result));
    }
}
