package com.example.diplom_boot.service;

import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.model.SportClubModel;
import com.example.diplom_boot.repository.AthleteRepo;
import com.example.diplom_boot.repository.SportClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportClubService {

    private final SportClubRepo sportClubRepo;
    private final AthleteRepo athleteRepo;

    @Autowired
    public SportClubService(SportClubRepo sportClubRepo, AthleteRepo athleteRepo) {
        this.sportClubRepo = sportClubRepo;
        this.athleteRepo = athleteRepo;
    }

    public List<SportClubModel> findAll() {
        return sportClubRepo.findAll();
    }

    public SportClubModel findById(Long id) {
        return sportClubRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public List<AthleteModel> findAthletesBySportClub(Long id) {
        return athleteRepo.findAthletesBySportClub(id);

    }

}
