package com.example.diplom_boot.DTO;

import com.example.diplom_boot.model.CoachModel;
import com.example.diplom_boot.model.SportClubModel;

public class TeamDTO {
    SportClubModel sportClub;
    CoachModel coach;
    String name;

    TeamDTO(SportClubModel sportClub, CoachModel coach, String name) {
        this.sportClub = sportClub;
        this.coach = coach;
        this.name = name;
    }

    public SportClubModel getSportClub() {
        return sportClub;
    }

    public void setSportClub(SportClubModel sportClub) {
        this.sportClub = sportClub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoachModel getCoach() {
        return coach;
    }

    public void setCoach(CoachModel coach) {
        this.coach = coach;
    }
}
