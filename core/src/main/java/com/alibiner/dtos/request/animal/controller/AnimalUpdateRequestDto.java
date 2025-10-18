package com.alibiner.dtos.request.animal.controller;


import java.util.*;
import com.alibiner.annotations.ValueOfEnum;
import com.alibiner.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnimalUpdateRequestDto {

    @NotNull(message = "animal id can not be null")
    @JsonProperty(value = "id", required = true)
    private UUID id;

    @NotNull(message = "animal name can not be null")
    private String name;

    @NotNull(message = "animal species id can not be null")
    @JsonProperty(value = "speciesId", required = true)
    private UUID speciesId;

    @NotNull(message = "animal breed can not be null")
    private String breed;

    @ValueOfEnum(enumClass = Gender.class, values = "MALE,FEMALE")
    private String gender;

    @NotNull(message = "animal birth of date can not be null")
    private LocalDate birthOfDate;

    @NotNull(message = "animal color id can not be null")
    @JsonProperty(value = "colorId", required = true)
    private UUID colorId;

    @NotNull(message = "animal owner id can not be null")
    @JsonProperty(value = "ownerId", required = true)
    private UUID ownerId;
}
