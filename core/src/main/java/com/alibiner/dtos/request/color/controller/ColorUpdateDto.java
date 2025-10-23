package com.alibiner.dtos.request.color.controller;

import java.util.*;
import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ColorUpdateDto {
    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID id;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.ValidationMessages.NOT_BLANK)
    private String name;

    public ColorUpdateDto() {
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
}
