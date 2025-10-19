package com.alibiner.entities;

import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "AvailableDate{" +
                "availableDate=" + availableDate +
                ", id=" + id +
                '}';
    }
}
