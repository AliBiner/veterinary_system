package com.alibiner.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Species extends BaseEntity {

    @Column(name = "species_name", nullable = false)
    private String name;

    @Column(name = "is_delete", columnDefinition = "boolean default false")
    private boolean isDelete = false;
}
