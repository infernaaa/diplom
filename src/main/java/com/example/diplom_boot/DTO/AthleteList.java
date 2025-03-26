package com.example.diplom_boot.DTO;

import com.example.diplom_boot.model.AthleteModel;

import java.util.ArrayList;
import java.util.List;

public class AthleteList {

    List<AthleteModel> athleteList;

    public List<AthleteModel> getClubs() {
        return athleteList;
    }

    public void setClubs(List<AthleteModel> clubs) {
        this.athleteList = clubs;
    }
}
