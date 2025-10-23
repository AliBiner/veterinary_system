package com.alibiner.dtos.request.color.controller;

import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ColorCreateRequestDto {
    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.ValidationMessages.NOT_BLANK)
    private String name;

    public ColorCreateRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
