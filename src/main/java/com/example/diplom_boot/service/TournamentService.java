package com.example.diplom_boot.service;

import com.example.diplom_boot.DTO.TournamentDTO;
import com.example.diplom_boot.model.TournamentModel;
import com.example.diplom_boot.repository.ApplicationRepo;
import com.example.diplom_boot.repository.TournamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    private final TournamentRepo tournamentRepo;
    private final ApplicationRepo applicationRepo;

    @Autowired
    public TournamentService(TournamentRepo tournamentRepo, ApplicationRepo applicationRepo) {
        this.tournamentRepo = tournamentRepo;
        this.applicationRepo = applicationRepo;
    }

    public List<TournamentModel> findAll(){
        return tournamentRepo.findAll();
    }

    public TournamentModel findById(Long id){
        return tournamentRepo.findById(id)
                .orElseThrow(() ->  new RuntimeException("Not found"));
    }

    public TournamentDTO findInfo(Long id){
        TournamentDTO tournamentDTO = new TournamentDTO();
        TournamentModel tournamentModel = findById(id);
        tournamentDTO.setTournamentId(id);
        tournamentDTO.setTournamentName(tournamentModel.getName());
        tournamentDTO.setTournamentLocation(tournamentModel.getLocation());
        tournamentDTO.setTournamentDescription(tournamentModel.getDescription());
        tournamentDTO.setTournamentRules(tournamentModel.getRules());
        tournamentDTO.setSportClubs(applicationRepo.findBySportClubId(id));
        tournamentDTO.setTeams( applicationRepo.findByTeamId(id));
        tournamentDTO.setAthlete(applicationRepo.findByAthlete(id));
        return tournamentDTO;
    }
}
