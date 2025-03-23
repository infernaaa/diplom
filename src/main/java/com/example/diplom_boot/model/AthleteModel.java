package com.example.diplom_boot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "athlete")
public class AthleteModel {
    @Id
    @Column(name = "athlete_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_club")
    private SportClubModel idClub;

    @Column(name = "fio", length = 50)
    private String fio;

    @Column(name = "bday")
    private LocalDate bday;

    @Column(name = "rank", length = 50)
    private String rank;

    @Column(name = "category", length = 50)
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SportClubModel getIdClub() {
        return idClub;
    }

    public void setIdClub(SportClubModel idClub) {
        this.idClub = idClub;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}