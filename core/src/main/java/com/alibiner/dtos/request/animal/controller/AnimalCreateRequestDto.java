package com.alibiner.dtos.request.animal.controller;

import java.util.*;
import com.alibiner.annotations.ValueOfEnum;
import com.alibiner.enums.Gender;
import com.alibiner.errorMessages.ErrorMessages;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
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
}
