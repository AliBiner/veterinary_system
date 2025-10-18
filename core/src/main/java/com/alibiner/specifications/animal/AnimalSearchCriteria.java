package com.alibiner.specifications.animal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalSearchCriteria {
    private String animalName;
    private String ownerPhone;
    private String ownerMail;
}
