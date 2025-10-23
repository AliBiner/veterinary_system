package com.alibiner.dtos.request.animal.service;


import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.enums.Gender;
import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class AnimalRequestDto implements BaseRequestDto {
    private UUID id;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private String name;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID speciesId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private String breed;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private Gender gender;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private LocalDate birthOfDate;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID colorId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID userId;

}
