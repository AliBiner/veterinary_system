package com.alibiner.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class City extends BaseEntity {

    @Column(name = "city_name", nullable = false, length = 50)
    private String name;

    @Column(name = "is_delete", nullable = false, columnDefinition = "boolean default false")
    private boolean isDelete = false;

}
