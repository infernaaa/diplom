package com.example.diplom_boot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sport_club")
public class SportClubModel {
    @Id
    @Column(name = "sport_club_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "phone_club", length = 15)
    private String phoneClub;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneClub() {
        return phoneClub;
    }

    public void setPhoneClub(String phoneClub) {
        this.phoneClub = phoneClub;
    }

}