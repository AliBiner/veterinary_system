package com.alibiner.dtos.request.color.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ColorUpdateDto {
    @NotNull(message = "Color id can not be null")
    @Positive(message = "Color id can not be negative or zero")
    private long id;

    @NotNull(message = "Color name can not be null")
    @NotBlank(message = "Color name can not be blank")
    private String name;
}
