package com.alibiner.specifications.availableDate;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AvailableDateSearchCriteria {
    private LocalDate minDate;
    private LocalDate maxDate;
}
