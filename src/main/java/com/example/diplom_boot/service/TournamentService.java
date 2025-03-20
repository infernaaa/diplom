package com.example.diplom_boot.service;

import com.example.diplom_boot.DTO.TournamentDTO;
import com.example.diplom_boot.model.TournamentInfoModel;
import com.example.diplom_boot.model.TournamentModel;
import com.example.diplom_boot.repository.ApplicationRepo;
import com.example.diplom_boot.repository.TournamentInfoRepo;
import com.example.diplom_boot.repository.TournamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    private final TournamentRepo tournamentRepo;
    private final TournamentInfoRepo tournamentInfoRepo;
    private final ApplicationRepo applicationRepo;

    @Autowired
    public TournamentService(TournamentRepo tournamentRepo, TournamentInfoRepo tournamentInfoRepo, ApplicationRepo applicationRepo) {
        this.tournamentRepo = tournamentRepo;
        this.tournamentInfoRepo = tournamentInfoRepo;
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
        TournamentInfoModel tournamentInfoModel = tournamentInfoRepo.findById(id).get();
        tournamentDTO.setTournamentId(id);
        tournamentDTO.setTournamentName(tournamentModel.getTurnament_name());
        tournamentDTO.setTournamentLocation(tournamentModel.getLocation());
        tournamentDTO.setTournamentDescription(tournamentInfoModel.getDescription());
        tournamentDTO.setTournamentRules(tournamentInfoModel.getRules());
        tournamentDTO.setPrizeFound(tournamentInfoModel.getPrizeFund());
        List<Long> sportClubs_id = applicationRepo.findBySportClubId(id);
        List<Long> team_id =  applicationRepo.findByTeamId(id);;
        List<Long> athlete_id = applicationRepo.findByAthlete(id);;
        tournamentDTO.setSportClubs_id(sportClubs_id);
        tournamentDTO.setTeam_id(team_id);
        tournamentDTO.setAthlete_id(athlete_id);
        return tournamentDTO;
    }
}
