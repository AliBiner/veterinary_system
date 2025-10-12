package com.alibiner.dtos.request.city.controller;

import java.util.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityUpdateRequestDto {
    @NotNull(message = "City id can not be null")
    private UUID id;

    @NotNull(message = "City name can not be null")
    @NotBlank(message = "City name can not be blank")
    private String name;
}
