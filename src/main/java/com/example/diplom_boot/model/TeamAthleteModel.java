package com.example.diplom_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "team_athlete")
public class TeamAthleteModel {
    @EmbeddedId
    private TeamAthleteId id;

    @MapsId("teamId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    private TeamModel team;

    @MapsId("athleteId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "athlete_id", nullable = false)
    private AthleteModel athleteModel;

    public TeamAthleteId getId() {
        return id;
    }

    public void setId(TeamAthleteId id) {
        this.id = id;
    }

    public TeamModel getTeam() {
        return team;
    }

    public void setTeam(TeamModel teamModel) {
        this.team = teamModel;
    }

    public AthleteModel getAthlete() {
        return athleteModel;
    }

    public void setAthlete(AthleteModel athleteModel) {
        this.athleteModel = athleteModel;
    }

}