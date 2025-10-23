package com.alibiner.dtos.response.animal.service;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;
import com.alibiner.enums.Gender;

import java.time.LocalDate;


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

    public AnimalResponseDto(UUID id, String name, String species, String breed, String color, UUID ownerId, String owner, Gender gender, LocalDate birthOfDate) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.color = color;
        this.ownerId = ownerId;
        this.owner = owner;
        this.gender = gender;
        this.birthOfDate = birthOfDate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public String getOwner() {
        return owner;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }
}
