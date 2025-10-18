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
@Table(name = "users",
        indexes = {
                @Index(name = "phone_unique_index", columnList = "phone, userType, isDelete", unique = true),
                @Index(name = "mail_unique_index", columnList = "mail, userType, isDelete", unique = true),
        })
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @Column(name = "user_phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "user_mail", nullable = false)
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Animal> animals;


    public User(String name, String phone, String mail, String address, UserType userType) {
        this(null, name, phone, mail, address, userType);

    }

    public User(UUID id, String name, String phone, String mail, String address, UserType userType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.userType = userType;
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
                '}';
    }
}
