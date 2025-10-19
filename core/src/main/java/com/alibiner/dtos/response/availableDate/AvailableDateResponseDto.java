package com.alibiner.dtos.response.availableDate;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AvailableDateResponseDto implements BaseResponseDto {
    private UUID id;
    private LocalDate availableDate;
    private String doctorName;
    private UUID doctorId;
}
