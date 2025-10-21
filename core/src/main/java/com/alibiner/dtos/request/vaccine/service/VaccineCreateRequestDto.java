package com.alibiner.dtos.request.vaccine.service;

import java.util.*;
import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class VaccineCreateRequestDto extends VaccineBaseRequestDto {
    private UUID id;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.ValidationMessages.NOT_BLANK)
    private String name;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private String description;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.ValidationMessages.NOT_BLANK)
    @Length(min = 10, max = 20)
    private String code;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @PositiveOrZero(message = ErrorMessages.ValidationMessages.POSITIVE_OR_ZERO)
    private Integer vaccineCycle;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @PositiveOrZero(message = ErrorMessages.ValidationMessages.POSITIVE_OR_ZERO)
    private Integer flexibleCycle;
}
