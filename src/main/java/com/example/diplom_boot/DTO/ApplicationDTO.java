package com.example.diplom_boot.DTO;

import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.model.SportClubModel;
import com.example.diplom_boot.model.TeamModel;
import com.example.diplom_boot.model.TournamentModel;

import java.time.LocalDate;

public class ApplicationDTO {

    private Long id;
    private TournamentModel tour;
    private SportClubModel sportClub;
    private TeamModel team;
    private AthleteModel athlete;
    private String status;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TournamentModel getTour() {
        return tour;
    }

    public void setTour(TournamentModel tour) {
        this.tour = tour;
    }

    public SportClubModel getSportClub() {
        return sportClub;
    }

    public void setSportClub(SportClubModel sportClub) {
        this.sportClub = sportClub;
    }

    public TeamModel getTeam() {
        return team;
    }

    public void setTeam(TeamModel team) {
        this.team = team;
    }

    public AthleteModel getAthlete() {
        return athlete;
    }

    public void setAthlete(AthleteModel athlete) {
        this.athlete = athlete;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
