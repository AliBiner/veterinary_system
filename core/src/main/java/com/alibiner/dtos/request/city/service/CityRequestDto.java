package com.alibiner.dtos.request.city.service;


import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;


public class CityRequestDto implements BaseRequestDto {
    private UUID id;
    private String name;

    public CityRequestDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
