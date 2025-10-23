package com.alibiner.specifications.examination.verify;

import java.util.*;
import org.springframework.lang.NonNull;


public class ExaminationVerifyCriteria {
    private UUID examinationId;
    private UUID animalId;
    private UUID vaccineId;

    public ExaminationVerifyCriteria(UUID examinationId, @NonNull UUID animalId, @NonNull UUID vaccineId) {
        this.examinationId = examinationId;
        this.animalId = animalId;
        this.vaccineId = vaccineId;
    }

    public UUID getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(UUID examinationId) {
        this.examinationId = examinationId;
    }

    public UUID getAnimalId() {
        return animalId;
    }

    public void setAnimalId(UUID animalId) {
        this.animalId = animalId;
    }

    public UUID getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(UUID vaccineId) {
        this.vaccineId = vaccineId;
    }
}
