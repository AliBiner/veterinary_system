package com.alibiner.dtos.request.species.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SpeciesUpdateRequestDto {

    @NotNull(message = "species id can not be null")
    @Positive(message = "species id can not be negative or zero")
    private long id;

    @NotNull(message = "species name can not be null")
    @NotBlank(message = "species name can not be blank")
    private String name;

}
