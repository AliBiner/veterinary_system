package com.alibiner.specifications.availableDate.verify;

import java.util.*;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Data
public class AvailableDateVerifyCriteria {
    private UUID doctorId;
    private LocalDate appointmentDate;

    public AvailableDateVerifyCriteria(@NonNull UUID doctorId, @NonNull LocalDate appointmentDate) {
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }
}
