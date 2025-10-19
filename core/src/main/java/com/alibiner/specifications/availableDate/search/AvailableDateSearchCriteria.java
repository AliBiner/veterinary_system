package com.alibiner.specifications.availableDate.search;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AvailableDateSearchCriteria {
    private UUID doctorId;
    private LocalDate minDate;
    private LocalDate maxDate;

    public AvailableDateSearchCriteria(LocalDate minDate, LocalDate maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
    }
}
