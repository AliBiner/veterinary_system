package com.alibiner.veterinary_management_system.controllers;

import com.alibiner.config.modelMapper.IModelMapperService;
import com.alibiner.dtos.request.color.controller.ColorCreateRequestDto;
import com.alibiner.dtos.request.color.controller.ColorUpdateDto;
import com.alibiner.dtos.request.color.service.ColorRequestDto;
import com.alibiner.dtos.response.color.ColorResponseDto;
import com.alibiner.interfaces.color.IColorService;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @Valid
            @Positive(message = "Id can not be negative or zero")
            @RequestParam(name = "id", required = false)
            long id
    ) {
        colorService.delete(id);
        return ResponseEntity.ok(Result.ok());
    }
}
