package com.alibiner.dtos.response.vaccine.service;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;


public class VaccineResponseDto implements BaseResponseDto {
    private UUID id;

    private String name;

    private String description;

    private String code;

    private int vaccineCycle;

    private int flexibleCycle;

    private boolean isActive;

    public VaccineResponseDto() {
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

    public int getVaccineCycle() {
        return vaccineCycle;
    }

    public void setVaccineCycle(int vaccineCycle) {
        this.vaccineCycle = vaccineCycle;
    }

    public int getFlexibleCycle() {
        return flexibleCycle;
    }

    public void setFlexibleCycle(int flexibleCycle) {
        this.flexibleCycle = flexibleCycle;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
