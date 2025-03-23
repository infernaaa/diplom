package com.example.diplom_boot.DTO;

import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.model.SportClubModel;
import com.example.diplom_boot.model.TeamModel;

import java.util.List;

public class TournamentDTO {
    private Long tournamentId;
    private String tournamentName;
    private String tournamentLocation;
    private String tournamentDescription;
    private String tournamentRules;
    List<SportClubModel> sportClubs;
    List<AthleteModel> athlete;
    List<TeamModel> teams;

    public List<TeamModel> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamModel> teams) {
        this.teams = teams;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentLocation() {
        return tournamentLocation;
    }

    public void setTournamentLocation(String tournamentLocation) {
        this.tournamentLocation = tournamentLocation;
    }

    public String getTournamentDescription() {
        return tournamentDescription;
    }

    public void setTournamentDescription(String tournamentDescription) {
        this.tournamentDescription = tournamentDescription;
    }

    public String getTournamentRules() {
        return tournamentRules;
    }

    public void setTournamentRules(String tournamentRules) {
        this.tournamentRules = tournamentRules;
    }

    public List<SportClubModel> getSportClubs() {
        return sportClubs;
    }

    public void setSportClubs(List<SportClubModel> sportClubs) {
        this.sportClubs = sportClubs;
    }

    public List<AthleteModel> getAthlete() {
        return athlete;
    }

    public void setAthlete(List<AthleteModel> athlete) {
        this.athlete = athlete;
    }
}
