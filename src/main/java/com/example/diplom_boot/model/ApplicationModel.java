package com.example.diplom_boot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "application")
public class ApplicationModel {
    @Id
    @Column(name = "application_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private TournamentModel tournament;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sport_club_id")
    private SportClubModel sportClub;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamModel teamModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "athlete_id")
    private AthleteModel athleteModel;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TournamentModel getTournament() {
        return tournament;
    }

    public void setTournament(TournamentModel tournament) {
        this.tournament = tournament;
    }

    public SportClubModel getSportClub() {
        return sportClub;
    }

    public void setSportClub(SportClubModel sportClubModel) {
        this.sportClub = sportClubModel;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

}