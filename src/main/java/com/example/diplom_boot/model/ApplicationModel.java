package com.example.diplom_boot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "application")
public class ApplicationModel {
    @Id
    @Column(name = "application_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private TournamentModel tournamentModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sport_club_id")
    private SportClubModel sportClubModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamModel teamModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "athlete_id")
    private AthleteModel athleteModel;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "application_date")
    private LocalDate applicationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TournamentModel getTournament() {
        return tournamentModel;
    }

    public void setTournament(TournamentModel tournamentModel) {
        this.tournamentModel = tournamentModel;
    }

    public SportClubModel getSportClub() {
        return sportClubModel;
    }

    public void setSportClub(SportClubModel sportClubModel) {
        this.sportClubModel = sportClubModel;
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