package com.alibiner.dtos.response.animal.service;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;
import com.alibiner.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AnimalResponseDto implements BaseResponseDto {
    private UUID id;
    private String name;
    private String species;
    private String breed;
    private String color;
    private UUID ownerId;
    private String owner;
    private Gender gender;
    private LocalDate birthOfDate;
}
