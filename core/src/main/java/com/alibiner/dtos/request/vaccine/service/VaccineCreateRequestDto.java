package com.alibiner.dtos.request.vaccine.service;

import java.util.*;
import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;


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

    public VaccineCreateRequestDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getVaccineCycle() {
        return vaccineCycle;
    }

    public void setVaccineCycle(Integer vaccineCycle) {
        this.vaccineCycle = vaccineCycle;
    }

    public Integer getFlexibleCycle() {
        return flexibleCycle;
    }

    public void setFlexibleCycle(Integer flexibleCycle) {
        this.flexibleCycle = flexibleCycle;
    }
}
