package com.alibiner.entities;

import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "examinations")
@Getter
@Setter
public class Examination extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "examination_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccine_id", nullable = false)
    private Vaccine vaccine;

    @Column(name = "examination_date", nullable = false)
    @CreationTimestamp
    private LocalDate examinationDate;

    @Column(name = "examination_vaccine_cycle_date")
    private LocalDate vaccineCycleDate;

    @Column(name = "examination_vaccine_flexible_date")
    private LocalDate vaccineFlexibleDate;
}
