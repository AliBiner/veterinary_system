package com.alibiner.dtos.request.species.controller;

import java.util.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SpeciesUpdateRequestDto {

    @NotNull(message = "species id can not be null")
    private UUID id;

    @NotNull(message = "species name can not be null")
    @NotBlank(message = "species name can not be blank")
    private String name;

}
