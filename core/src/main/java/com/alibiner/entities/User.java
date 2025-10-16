package com.alibiner.entities;

import java.util.*;
import com.alibiner.enums.UserType;
import com.alibiner.enums.UserTypeConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @Column(name = "user_phone", nullable = false, length = 10, unique = true)
    private String phone;

    @Column(name = "user_mail", nullable = false, unique = true)
    private String mail;

    @Column(name = "user_address", nullable = false)
    private String address;

    @Column(name = "is_delete", columnDefinition = "boolean default false")
    private boolean isDelete = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "user_type", nullable = false)
    @Convert(converter = UserTypeConverter.class)
    private UserType userType;


    public User(String name, String phone, String mail, String address) {
        this(null, name, phone, mail, address);

    }

    public User(UUID id, String name, String phone, String mail, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", address='" + address + '\'' +
                ", isDelete=" + isDelete +
                ", city=" + city +
                '}';
    }
}
