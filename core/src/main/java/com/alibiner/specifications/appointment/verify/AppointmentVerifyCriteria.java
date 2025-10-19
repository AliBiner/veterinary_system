package com.alibiner.specifications.appointment.verify;

import java.util.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class AppointmentVerifyCriteria {

    private UUID doctorId;
    private LocalDateTime appointmentDate;

    public AppointmentVerifyCriteria(@NonNull UUID doctorId, @NonNull LocalDateTime appointmentDate) {
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }
}
