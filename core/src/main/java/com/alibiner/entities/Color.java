package com.alibiner.entities;

import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "colors")
public class Color extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "color_id")
    private UUID id;

    @Column(name = "color_name", nullable = false)
    private String name;

    @Column(name = "is_delete", columnDefinition = "boolean default false")
    private boolean isDelete = false;
}
