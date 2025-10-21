package com.alibiner.dtos.response.examination.service;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ExaminationResponseDto implements BaseResponseDto {
    private UUID id;
    private UUID vaccineId;
    private UUID appointmentId;
    private LocalDate examinationDate;
    private LocalDate vaccineCycleDate;
    private LocalDate vaccineFlexibleCycleDate;
}
