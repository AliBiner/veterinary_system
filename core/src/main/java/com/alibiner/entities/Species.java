package com.alibiner.entities;


import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "species")
public class Species extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "species_id")
    private UUID id;

    @Column(name = "species_name", nullable = false)
    private String name;

    @Column(name = "is_delete", columnDefinition = "boolean default false")
    private boolean isDelete = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "species")
    private List<Animal> animals;

    public Species() {
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
