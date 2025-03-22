package com.example.diplom_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "team_athlete")
public class TeamAthleteModel {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamModel teamModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "athlete_id")
    private AthleteModel athleteModel;
    @Id
    private Long id;

    public TeamModel getTeam() {
        return teamModel;
    }

    public void setTeam(TeamModel teamModel) {
        this.teamModel = teamModel;
    }

    public AthleteModel getAthlete() {
        return athleteModel;
    }

    public void setAthlete(AthleteModel athleteModel) {
        this.athleteModel = athleteModel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}