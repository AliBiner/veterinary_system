package com.alibiner.entities;

import java.util.*;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "available_dates",
        uniqueConstraints = {
                @UniqueConstraint(name = "available_dates_unique_constraint", columnNames = {"available_date", "user_id"})
        })
public class AvailableDate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "available_date_id")
    private UUID id;

    @Column(name = "available_date", nullable = false)
    private LocalDate availableDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public AvailableDate() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AvailableDate{" +
                "availableDate=" + availableDate +
                ", id=" + id +
                '}';
    }
}
