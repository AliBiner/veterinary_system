package com.alibiner.specifications.examination.verify;

import java.util.*;
import lombok.Data;
import lombok.NonNull;

@Data
public class ExaminationVerifyCriteria {
    private UUID examinationId;
    private UUID animalId;
    private UUID vaccineId;

    public ExaminationVerifyCriteria(UUID examinationId, @NonNull UUID animalId, @NonNull UUID vaccineId) {
        this.examinationId = examinationId;
        this.animalId = animalId;
        this.vaccineId = vaccineId;
    }
}
