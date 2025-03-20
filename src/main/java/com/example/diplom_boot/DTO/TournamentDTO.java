package com.example.diplom_boot.DTO;

import java.util.List;

public class TournamentDTO {
    private Long tournamentId;
    private String tournamentName;
    private String tournamentLocation;
    private String tournamentDescription;
    private String tournamentRules;
    private String prizeFound;
    List<Long> sportClubs_id;
    List<Long> athlete_id;
    List<Long> team_id;

    public List<Long> getTeam_id() {
        return team_id;
    }

    public void setTeam_id(List<Long> team_id) {
        this.team_id = team_id;
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

    public String getPrizeFound() {
        return prizeFound;
    }

    public void setPrizeFound(String prizeFound) {
        this.prizeFound = prizeFound;
    }

    public String getTournamentRules() {
        return tournamentRules;
    }

    public void setTournamentRules(String tournamentRules) {
        this.tournamentRules = tournamentRules;
    }

    public List<Long> getSportClubs_id() {
        return sportClubs_id;
    }

    public void setSportClubs_id(List<Long> sportClubs_id) {
        this.sportClubs_id = sportClubs_id;
    }

    public List<Long> getAthlete_id() {
        return athlete_id;
    }

    public void setAthlete_id(List<Long> athlete_id) {
        this.athlete_id = athlete_id;
    }
}
