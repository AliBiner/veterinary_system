package com.alibiner.dtos.request.animal.controller;

import java.util.*;
import com.alibiner.annotations.ValueOfEnum;
import com.alibiner.enums.Gender;
import com.alibiner.errorMessages.ErrorMessages;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public class AnimalCreateRequestDto {
    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @JsonProperty(value = "speciesId", required = true)
    private UUID speciesId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private String name;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private String breed;

    @ValueOfEnum(enumClass = Gender.class, values = "MALE,FEMALE")
    private String gender;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private LocalDate birthOfDate;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @JsonProperty(value = "colorId", required = true)
    private UUID colorId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @JsonProperty(value = "ownerId", required = true)
    private UUID ownerId;

    public AnimalCreateRequestDto() {
    }

    public UUID getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(UUID speciesId) {
        this.speciesId = speciesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }
}
