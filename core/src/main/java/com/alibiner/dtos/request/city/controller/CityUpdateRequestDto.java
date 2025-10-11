package com.alibiner.dtos.request.city.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityUpdateRequestDto {
    @NotNull(message = "City id can not be null")
    @Positive(message = "City id can not be negative or zero")
    private Long id;

    @NotNull(message = "City name can not be null")
    @NotBlank(message = "City name can not be blank")
    private String name;
}
