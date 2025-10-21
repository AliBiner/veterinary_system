package com.alibiner.specifications.examination.search;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ExaminationSearchCriteria {
    private UUID animalId;
    private LocalDate minExaminationDate;
    private LocalDate maxExaminationDate;
    private LocalDate minVaccineFlexibleCycleDate;
    private LocalDate maxVaccineFlexibleCycleDate;
}
