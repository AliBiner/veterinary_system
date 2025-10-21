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

    @Column(name = "vaccine_code", nullable = false, length = 20, unique = true)
    private String code;

    @Column(name = "vaccine_cycle", nullable = false)
    private int vaccineCycle;

    @Column(name = "flexible_cycle", nullable = false)
    private int flexibleCycle;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private boolean isActive = true;

    public Vaccine(String name, String code) {
        this(null, name, null, code, 0, 0, true);
    }

    public Vaccine(String name, String description, String code) {
        this(null, name, description, code, 0, 0, true);
    }

    public Vaccine(String name, String description, String code, int vaccineCycle, int flexibleCycle) {
        this(null, name, description, code, vaccineCycle, flexibleCycle, true);
    }

    public Vaccine(UUID id, String name, String description, String code, int vaccineCycle, int flexibleCycle, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        setCode(code);
        this.vaccineCycle = vaccineCycle;
        this.flexibleCycle = flexibleCycle;
        this.isActive = isActive;
    }

    public void setCode(String code) {
        this.code = code.toUpperCase();
    }
}
