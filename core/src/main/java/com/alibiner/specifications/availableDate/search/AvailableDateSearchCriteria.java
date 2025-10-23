package com.alibiner.specifications.availableDate.search;

import java.util.*;

import java.time.LocalDate;


public class AvailableDateSearchCriteria {
    private UUID doctorId;
    private LocalDate minDate;
    private LocalDate maxDate;

    public AvailableDateSearchCriteria(LocalDate minDate, LocalDate maxDate) {
        this(null, minDate, maxDate);
    }

    public AvailableDateSearchCriteria(UUID doctorId, LocalDate minDate, LocalDate maxDate) {
        this.doctorId = doctorId;
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    public AvailableDateSearchCriteria() {
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDate minDate) {
        this.minDate = minDate;
    }

    public LocalDate getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDate maxDate) {
        this.maxDate = maxDate;
    }
}
