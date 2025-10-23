package com.alibiner.entities;

import java.util.*;
import com.alibiner.enums.UserType;
import com.alibiner.enums.UserTypeConverter;
import jakarta.persistence.*;


@Entity
@Table(name = "users",
        indexes = {
                @Index(name = "phone_unique_index", columnList = "user_phone, user_type, is_delete", unique = true),
                @Index(name = "mail_unique_index", columnList = "user_mail, user_type, is_delete", unique = true),
        })

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<AvailableDate> availableDates;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    List<Appointment> appointments;

    public User() {
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<AvailableDate> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<AvailableDate> availableDates) {
        this.availableDates = availableDates;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
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
                ", userType=" + userType +
                '}';
    }


}
