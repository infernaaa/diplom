package com.example.diplom_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coach")
public class CoachModel {
    @Id
    @Column(name = "coach_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "athlete_id")
    private AthleteModel athleteModel;

    @Column(name = "fio", length = 50)
    private String fio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AthleteModel getAthlete() {
        return athleteModel;
    }

    public void setAthlete(AthleteModel athleteModel) {
        this.athleteModel = athleteModel;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

}