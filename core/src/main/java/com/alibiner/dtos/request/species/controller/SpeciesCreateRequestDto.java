package com.alibiner.dtos.request.species.controller;

import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class SpeciesCreateRequestDto {

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.ValidationMessages.NOT_BLANK)
    private String name;

    public SpeciesCreateRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
