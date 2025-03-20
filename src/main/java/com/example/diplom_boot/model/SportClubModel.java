package com.example.diplom_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sport_club")
public class SportClubModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="sport_club_id")
    private Long idSportClub;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_club")
    private String phone_club;

    public Long getIdSportClub() {
        return idSportClub;
    }

    public void setIdSportClub(Long idSportClub) {
        this.idSportClub = idSportClub;
    }

    public String getPhone_club() {
        return phone_club;
    }

    public void setPhone_club(String phone_club) {
        this.phone_club = phone_club;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
