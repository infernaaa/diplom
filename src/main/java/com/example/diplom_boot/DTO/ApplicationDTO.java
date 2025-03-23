package com.example.diplom_boot.DTO;

import java.time.LocalDate;

public class ApplicationDTO {

    private Long id;
    private Long tourId;
    private Long sportClubId;
    private Long teamId;
    private Long athleteId;
    private String status;
    private LocalDate date;

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSportClubId() {
        return sportClubId;
    }

    public void setSportClubId(Long sportClubId) {
        this.sportClubId = sportClubId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
