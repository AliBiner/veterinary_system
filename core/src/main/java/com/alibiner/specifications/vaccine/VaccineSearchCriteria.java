package com.alibiner.specifications.vaccine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VaccineSearchCriteria {
    private String name;
    private String description;
    private String code;
    private Boolean status;
}
