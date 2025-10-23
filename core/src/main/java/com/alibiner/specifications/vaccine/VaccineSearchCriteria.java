package com.alibiner.specifications.vaccine;

public class VaccineSearchCriteria {
    private String name;
    private String description;
    private String code;
    private Boolean status;

    public VaccineSearchCriteria(String name, String description, String code, Boolean status) {
        this.name = name;
        this.description = description;
        this.code = code;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
