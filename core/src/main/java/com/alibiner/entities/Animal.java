package com.alibiner.entities;

import java.util.*;
import com.alibiner.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "animals")
@Getter
@Setter
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
}
