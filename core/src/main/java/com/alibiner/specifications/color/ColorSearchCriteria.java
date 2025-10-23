package com.alibiner.specifications.color;

public class ColorSearchCriteria {
    private String name;

    public ColorSearchCriteria() {
    }

    public ColorSearchCriteria(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
