package com.alibiner.dtos.request.color.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ColorCreateRequestDto {
    @NotNull(message = "Color name can not be null")
    @NotBlank(message = "Color name can not be blank")
    private String name;
}
