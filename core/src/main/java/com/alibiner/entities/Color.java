package com.alibiner.entities;

import java.util.*;
import jakarta.persistence.*;


@Entity
@Table(name = "colors")
public class Color extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "color_id")
    private UUID id;

    @Column(name = "color_name", nullable = false)
    private String name;

    @Column(name = "is_delete", columnDefinition = "boolean default false")
    private boolean isDelete = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "color")
    private List<Animal> animals;

    public Color() {
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
