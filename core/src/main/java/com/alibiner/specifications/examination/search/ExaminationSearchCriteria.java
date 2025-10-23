package com.alibiner.specifications.examination.search;

import java.util.*;

import java.time.LocalDate;


public class ExaminationSearchCriteria {
    private UUID animalId;
    private LocalDate minExaminationDate;
    private LocalDate maxExaminationDate;
    private LocalDate minVaccineFlexibleCycleDate;
    private LocalDate maxVaccineFlexibleCycleDate;

    public ExaminationSearchCriteria() {
    }

    public ExaminationSearchCriteria(UUID animalId, LocalDate minExaminationDate, LocalDate maxExaminationDate, LocalDate minVaccineFlexibleCycleDate, LocalDate maxVaccineFlexibleCycleDate) {
        this.animalId = animalId;
        this.minExaminationDate = minExaminationDate;
        this.maxExaminationDate = maxExaminationDate;
        this.minVaccineFlexibleCycleDate = minVaccineFlexibleCycleDate;
        this.maxVaccineFlexibleCycleDate = maxVaccineFlexibleCycleDate;
    }

    public UUID getAnimalId() {
        return animalId;
    }

    public void setAnimalId(UUID animalId) {
        this.animalId = animalId;
    }

    public LocalDate getMinExaminationDate() {
        return minExaminationDate;
    }

    public void setMinExaminationDate(LocalDate minExaminationDate) {
        this.minExaminationDate = minExaminationDate;
    }

    public LocalDate getMaxExaminationDate() {
        return maxExaminationDate;
    }

    public void setMaxExaminationDate(LocalDate maxExaminationDate) {
        this.maxExaminationDate = maxExaminationDate;
    }

    public LocalDate getMinVaccineFlexibleCycleDate() {
        return minVaccineFlexibleCycleDate;
    }

    public void setMinVaccineFlexibleCycleDate(LocalDate minVaccineFlexibleCycleDate) {
        this.minVaccineFlexibleCycleDate = minVaccineFlexibleCycleDate;
    }

    public LocalDate getMaxVaccineFlexibleCycleDate() {
        return maxVaccineFlexibleCycleDate;
    }

    public void setMaxVaccineFlexibleCycleDate(LocalDate maxVaccineFlexibleCycleDate) {
        this.maxVaccineFlexibleCycleDate = maxVaccineFlexibleCycleDate;
    }
}
