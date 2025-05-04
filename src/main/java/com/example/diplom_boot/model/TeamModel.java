package com.example.diplom_boot.model;

import com.example.diplom_boot.repository.CoachRepo;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestParam;

@Entity
@Table(name = "team")
public class TeamModel {
    @Id
    @Column(name = "team_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sport_club_id")
    private SportClubModel sportClubModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    private CoachModel coachModel;

    @Column(name = "team_name", length = 50)
    private String teamName;

    public TeamModel(SportClubModel sportClubModel, CoachModel coachModel, String teamName) {
        this.sportClubModel = sportClubModel;
        this.coachModel = coachModel;
        this.teamName = teamName;
    }

    public TeamModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SportClubModel getSportClub() {
        return sportClubModel;
    }

    public void setSportClub(SportClubModel sportClubModel) {
        this.sportClubModel = sportClubModel;
    }

    public CoachModel getCoach() {
        return coachModel;
    }

    public void setCoach(CoachModel coachModel) {
        this.coachModel = coachModel;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}