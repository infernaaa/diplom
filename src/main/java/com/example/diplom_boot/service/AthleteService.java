package com.example.diplom_boot.service;

import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.repository.AthleteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService {
    AthleteRepo athleteRepo;

    @Autowired
    AthleteService(AthleteRepo athleteRepo) {
        this.athleteRepo = athleteRepo;
    }

    public List<AthleteModel> findAll() {
        return athleteRepo.findAll();
    }

    public void addAthleteToClub(AthleteModel athlete) {
        athleteRepo.save(athlete);
    }

    public void deleteAthlete(Long athlete) {
        athleteRepo.deleteById(athlete);
    }

    public AthleteModel findById(Long id) {
        return athleteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }
}
