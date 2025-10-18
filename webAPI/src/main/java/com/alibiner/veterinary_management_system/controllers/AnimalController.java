package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.dtos.request.animal.controller.AnimalCreateRequestDto;
import com.alibiner.dtos.request.animal.controller.AnimalUpdateRequestDto;
import com.alibiner.dtos.request.animal.service.AnimalRequestDto;
import com.alibiner.dtos.response.animal.service.AnimalResponseDto;
import com.alibiner.interfaces.animal.IAnimalService;
import com.alibiner.specifications.animal.AnimalSearchCriteria;
import com.alibiner.specifications.animal.AnimalSpecification;
import com.alibiner.veterinary_management_system.mappers.controller.animal.AnimalMapper;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {

    private final IAnimalService animalService;

    public AnimalController(IAnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<Result<AnimalResponseDto>> create(@Valid @RequestBody AnimalCreateRequestDto request) {
        AnimalRequestDto mappedAnimalRequest = AnimalMapper.toAnimalRequestDto(request);
        AnimalResponseDto result = animalService.create(mappedAnimalRequest);
        return ResponseEntity.ok(Result.ok(result));
    }

    @PutMapping
    public ResponseEntity<Result<AnimalResponseDto>> update(@Valid @RequestBody AnimalUpdateRequestDto request) {
        AnimalRequestDto animalRequestDto = AnimalMapper.toAnimalRequestDto(request);
        AnimalResponseDto result = animalService.update(animalRequestDto);
        return ResponseEntity.ok(Result.ok(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<AnimalResponseDto>> getById(@PathVariable UUID id) {
        AnimalResponseDto result = animalService.getById(id);
        return ResponseEntity.ok(Result.ok(result));
    }

    @GetMapping
    public ResponseEntity<Result<Page<AnimalResponseDto>>> getAll(
            @RequestParam(required = false, name = "animal-name") String animalName,
            @RequestParam(required = false, name = "owner-phone") String ownerPhone,
            @RequestParam(required = false, name = "owner-mail") String ownerMail,
            Pageable pageable
    ) {
        AnimalSearchCriteria criteria = new AnimalSearchCriteria(animalName, ownerPhone, ownerMail);
        AnimalSpecification specification = new AnimalSpecification(criteria);
        Page<AnimalResponseDto> result = animalService.getAll(pageable, specification);

        return ResponseEntity.ok(Result.ok(result));
    }
}
