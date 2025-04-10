package com.example.diplom_boot.service;

import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.repository.AthleteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AthleteService {
    AthleteRepo athleteRepo;

    @Autowired
    AthleteService(AthleteRepo athleteRepo) {
        this.athleteRepo = athleteRepo;
    }

    public void addAthleteToClub(AthleteModel athlete) {
        athleteRepo.save(athlete);
    }

    public void deleteAthlete(Long athlete) {
        athleteRepo.deleteById(athlete);
    }
}
