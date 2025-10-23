package com.alibiner.entities;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "city_id")
    private UUID id;

    @Column(name = "city_name", nullable = false, length = 50)
    private String name;

    @Column(name = "is_delete", nullable = false, columnDefinition = "boolean default false")
    private boolean isDelete = false;

    @OneToMany(mappedBy = "city")
    private List<User> users;

    public City() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isDelete=" + isDelete +
                ", users=" + users +
                '}';
    }
}
