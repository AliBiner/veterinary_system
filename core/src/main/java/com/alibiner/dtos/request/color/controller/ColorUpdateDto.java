package com.alibiner.dtos.request.color.controller;

import java.util.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ColorUpdateDto {
    @NotNull(message = "Color id can not be null")
    private UUID id;

    @NotNull(message = "Color name can not be null")
    @NotBlank(message = "Color name can not be blank")
    private String name;
}
