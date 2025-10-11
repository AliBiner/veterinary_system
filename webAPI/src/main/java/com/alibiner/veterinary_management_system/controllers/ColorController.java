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

    @PostMapping("/")
    public ResponseEntity<Result<ColorResponseDto>> create(@Valid @RequestBody(required = false) ColorCreateRequestDto dto) {
        ColorRequestDto mapped = modelMapperService.forRequest().map(dto, ColorRequestDto.class);
        ColorResponseDto result = colorService.create(mapped);
        return ResponseEntity.ok(Result.ok(result));
    }

    @PutMapping("/")
    public ResponseEntity<Result<ColorResponseDto>> update(@Valid @RequestBody(required = false) ColorUpdateDto request) {
        ColorRequestDto mapped = modelMapperService.forResponse().map(request, ColorRequestDto.class);
        ColorResponseDto result = colorService.update(mapped);
        return ResponseEntity.ok(Result.ok(result));
    }

    @DeleteMapping(value = "/", params = {"id"})
    public ResponseEntity<Result<Void>> delete(
            @RequestParam(name = "id", required = false)
            @Min(value = 1, message = "Id not be negative or zero")
            @NotNull(message = "Id can not be null")
            Long id
    ) {
        colorService.delete(id);
        return ResponseEntity.ok(Result.ok());
    }
}
