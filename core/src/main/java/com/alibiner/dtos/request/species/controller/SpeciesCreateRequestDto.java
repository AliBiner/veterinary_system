package com.alibiner.dtos.request.species.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SpeciesCreateRequestDto {

    @NotNull(message = "species name can not be null")
    @NotBlank(message = "species name can not be blank")
    private String name;
}
