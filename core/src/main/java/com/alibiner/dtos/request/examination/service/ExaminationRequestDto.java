package com.alibiner.dtos.request.examination.service;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExaminationRequestDto implements BaseRequestDto {
    private UUID id;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID appointmentId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID vaccineId;
}
