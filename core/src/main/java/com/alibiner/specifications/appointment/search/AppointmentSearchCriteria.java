package com.alibiner.specifications.appointment.search;

import java.util.*;
import com.alibiner.enums.AppointmentStatus;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Data
public class AppointmentSearchCriteria {

    private UUID doctorId;
    private UUID animalId;
    private UUID ownerId;
    private LocalDateTime minDate;
    private LocalDateTime maxDate;
    private AppointmentStatus status;

    public AppointmentSearchCriteria(@NonNull LocalDateTime minDate, @NonNull LocalDateTime maxDate, @NonNull AppointmentStatus status) {
        this(null, null, null, minDate, maxDate, status);
    }

    public AppointmentSearchCriteria(UUID doctorId, UUID animalId, UUID ownerId, @NonNull LocalDateTime minDate, @NonNull LocalDateTime maxDate, @NonNull AppointmentStatus status) {
        this.doctorId = doctorId;
        this.animalId = animalId;
        this.ownerId = ownerId;
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.status = status;
    }
}
