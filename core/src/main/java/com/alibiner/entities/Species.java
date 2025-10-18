package com.alibiner.entities;


import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
}
