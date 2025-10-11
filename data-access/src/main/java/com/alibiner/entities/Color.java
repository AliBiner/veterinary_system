package com.alibiner.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Color extends BaseEntity {

    @Column(name = "color_name", nullable = false)
    private String name;

    @Column(name = "is_delete", columnDefinition = "boolean default false")
    private boolean isDelete = false;
}
