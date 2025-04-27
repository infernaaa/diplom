package com.example.diplom_boot.service;

import com.example.diplom_boot.DTO.ApplicationDTO;
import com.example.diplom_boot.repository.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                    dto.setTour(application.getTournament());
                    dto.setSportClub(application.getSportClub());
                    dto.setTeam(application.getTeam());
                    dto.setAthlete(application.getAthlete());
                    dto.setStatus(application.getStatus());
                    dto.setDate(application.getApplicationDate());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
