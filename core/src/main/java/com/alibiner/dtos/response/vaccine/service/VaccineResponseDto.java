package com.alibiner.dtos.response.vaccine.service;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;
import lombok.Data;

@Data
public class VaccineResponseDto implements BaseResponseDto {
    private UUID id;

    private String name;

    private String description;

    private String code;

    private int vaccineCycle;

    private int flexibleCycle;

    private boolean isActive;
}
