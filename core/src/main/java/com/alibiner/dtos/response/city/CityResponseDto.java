package com.alibiner.dtos.response.city;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;

public class CityResponseDto implements BaseResponseDto {
    private UUID id;
    private String name;

    public CityResponseDto() {
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
