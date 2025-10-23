package com.alibiner.specifications.appointment.search;

import java.util.*;
import com.alibiner.enums.AppointmentStatus;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public class AppointmentSearchCriteria {

    private UUID doctorId;
    private UUID animalId;
    private UUID ownerId;
    private LocalDateTime minDate;
    private LocalDateTime maxDate;
    private AppointmentStatus status;

    public AppointmentSearchCriteria() {
    }

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

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getAnimalId() {
        return animalId;
    }

    public void setAnimalId(UUID animalId) {
        this.animalId = animalId;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDateTime getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDateTime minDate) {
        this.minDate = minDate;
    }

    public LocalDateTime getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDateTime maxDate) {
        this.maxDate = maxDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
