package com.alibiner.dtos.response.color;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;


public class ColorResponseDto implements BaseResponseDto {
    private UUID id;
    private String name;

    public ColorResponseDto() {
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
