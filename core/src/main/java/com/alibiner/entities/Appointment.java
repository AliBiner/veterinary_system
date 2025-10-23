package com.alibiner.entities;

import java.util.*;
import com.alibiner.enums.AppointmentStatus;
import com.alibiner.enums.AppointmentStatusConverter;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
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

    @OneToMany(mappedBy = "appointment", fetch = FetchType.LAZY)
    private List<Examination> examinations;

    public Appointment() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getCompanionName() {
        return companionName;
    }

    public void setCompanionName(String companionName) {
        this.companionName = companionName;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", animal=" + animal +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", status=" + status +
                ", companionName='" + companionName + '\'' +
                '}';
    }
}
