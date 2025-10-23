package com.alibiner.dtos.request.animal.service;


import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.enums.Gender;
import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public class AnimalRequestDto implements BaseRequestDto {
    private UUID id;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private String name;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID speciesId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private String breed;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private Gender gender;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private LocalDate birthOfDate;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID colorId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID userId;

    public AnimalRequestDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(UUID speciesId) {
        this.speciesId = speciesId;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(LocalDate birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public UUID getColorId() {
        return colorId;
    }

    public void setColorId(UUID colorId) {
        this.colorId = colorId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
