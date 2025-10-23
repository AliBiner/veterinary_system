package com.alibiner.entities;

import java.util.*;
import com.alibiner.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "animals")
public class Animal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "animal_id")
    private UUID id;

    @Column(name = "animal_name", nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    @Column(name = "animal_breed", nullable = false, length = 50)
    private String breed;

    @Column(name = "animal_gender", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @Column(name = "animal_birth_of_date", nullable = false)
    private LocalDate birthOfDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "is_delete", nullable = false, columnDefinition = "boolean default false")
    private boolean isDelete = false;

    @OneToMany(mappedBy = "animal")
    List<Appointment> appointments;


    public Animal() {
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

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(LocalDate birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
