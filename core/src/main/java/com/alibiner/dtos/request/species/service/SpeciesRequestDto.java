package com.alibiner.dtos.request.species.service;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;

public class SpeciesRequestDto implements BaseRequestDto {
    private UUID id;
    private String name;

    public SpeciesRequestDto() {
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
