package com.alibiner.dtos.request.animal.service;


import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.enums.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnimalRequestDto implements BaseRequestDto {
    private UUID id;

    @NotNull(message = "animal name can not be null")
    private String name;

    @NotNull(message = "animal species id can not be null")
    private UUID speciesId;

    @NotNull(message = "animal breed can not be null")
    private String breed;

    @NotNull(message = "animal gender can not be null")
    private Gender gender;

    @NotNull(message = "animal birth of date can not be null")
    private LocalDate birthOfDate;

    @NotNull(message = "animal color id can not be null")
    private UUID colorId;

    @NotNull(message = "animal user id can not be null")
    private UUID userId;

}
