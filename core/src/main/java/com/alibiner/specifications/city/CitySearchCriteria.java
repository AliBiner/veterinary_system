package com.alibiner.specifications.city;

public class CitySearchCriteria {
    private String name;

    public CitySearchCriteria() {
    }

    public CitySearchCriteria(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
