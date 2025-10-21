package com.alibiner.entities;

import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vaccines")
@Getter
@Setter
@NoArgsConstructor
public class Vaccine extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vaccine_id")
    private UUID id;

    @Column(name = "vaccine_name", nullable = false, length = 50)
    private String name;

    @Column(name = "vaccine_description", nullable = false)
    private String description;

    @Column(name = "vaccine_code", nullable = false, length = 20)
    private String code;

    @Column(name = "vaccine_cycle", nullable = false)
    private int vaccine_cycle;

    @Column(name = "flexible_cycle", nullable = false)
    private int flexible_cycle;
}
