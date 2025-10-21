package com.alibiner.dtos.request.vaccine.service;

import java.util.*;
import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class VaccineUpdateRequestDto extends VaccineBaseRequestDto {
    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID id;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.ValidationMessages.NOT_BLANK)
    private String name;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private String description;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @PositiveOrZero(message = ErrorMessages.ValidationMessages.POSITIVE_OR_ZERO)
    private Integer vaccineCycle;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @PositiveOrZero(message = ErrorMessages.ValidationMessages.POSITIVE_OR_ZERO)
    private Integer flexibleCycle;
}
