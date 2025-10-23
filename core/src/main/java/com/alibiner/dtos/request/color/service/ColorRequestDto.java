package com.alibiner.dtos.request.color.service;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;

public class ColorRequestDto implements BaseRequestDto {
    private UUID id;
    private String name;

    public ColorRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
