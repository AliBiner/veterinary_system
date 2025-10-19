package com.alibiner.entities;

import java.util.*;
import com.alibiner.enums.AppointmentStatus;
import com.alibiner.enums.AppointmentStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "appointments",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_appointment_constraint", columnNames = {"animal_id", "appointment_start_date", "appointment_finish_date", "appointment_status"})
        })
public class Appointment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "appointment_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Column(name = "appointment_start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "appointment_finish_date", nullable = false)
    private LocalDateTime finishDate;

    @Column(name = "appointment_status", nullable = false)
    @Convert(converter = AppointmentStatusConverter.class)
    private AppointmentStatus status;

    @Column(name = "companion_name", length = 100)
    private String companionName;
}
