package com.example.diplom_boot.service;

import com.example.diplom_boot.DTO.ApplicationDTO;
import com.example.diplom_boot.model.ApplicationModel;
import com.example.diplom_boot.repository.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicatonService {
    private final ApplicationRepo applicationRepo;

    @Autowired
    public ApplicatonService(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

    public List<ApplicationDTO> getAllApplications() {
        return applicationRepo.findAll()
                .stream()
                .map(application -> {
                    ApplicationDTO dto = new ApplicationDTO();
                    dto.setId(application.getId());
                    dto.setTourId(application.getTournament().getId());
                    dto.setSportClubId(application.getSportClub().getId());
                    dto.setTeamId(application.getTeam().getId());
                    dto.setAthleteId(application.getAthlete().getId());
                    dto.setStatus(application.getStatus());
                    dto.setDate(application.getApplicationDate());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
