package com.example.diplom_boot.service;

import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.model.TeamAthleteModel;
import com.example.diplom_boot.model.TeamModel;
import com.example.diplom_boot.repository.CoachRepo;
import com.example.diplom_boot.repository.TeamAthleteRepo;
import com.example.diplom_boot.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepo teamRepo;
    private final TeamAthleteRepo teamAthleteRepo;
    private final SportClubService sportClubService;
    private final CoachRepo coachRepo;
    private final AthleteService athleteService;

    @Autowired
    public TeamService(TeamRepo teamRepo, TeamAthleteRepo teamAthleteRepo, SportClubService sportClubService, CoachRepo coachRepo, AthleteService athleteService) {
        this.teamRepo = teamRepo;
        this.teamAthleteRepo = teamAthleteRepo;
        this.sportClubService = sportClubService;
        this.coachRepo = coachRepo;
        this.athleteService = athleteService;
    }

    public List<TeamModel> findAllTeams() {
        return teamRepo.findAll();
    }

    public TeamModel findTeamById(Long id) {
        return teamRepo.findById(id).orElseThrow(() -> new NullPointerException("нет такой команды"));
    }

    public List<AthleteModel> findMembersByTeamId(Long teamId) {
        return teamAthleteRepo.findMembersByTeamId(teamId);

    }
    public void save(TeamModel teamModel) {
        teamRepo.save(teamModel);
    }

    public void save(Long sportClubId, Long coachId, String name) {
        TeamModel teamModel = new TeamModel(
                sportClubService.findById(sportClubId),
                coachRepo.findById(coachId).get(),
                name);
        teamRepo.save(teamModel);
    }

    public List<TeamModel> findTeamBySportlubId(Long sportlubId) {
        return teamRepo.getTeamModelBySportClubID(sportlubId);
    }

    public void addAthleteToTeam(Long teamId, Long athleteId) {
        TeamAthleteModel teamAthleteModel = new TeamAthleteModel();
        teamAthleteModel.setAthlete(athleteService.findById(athleteId));
        teamAthleteModel.setTeam(teamRepo.findById(teamId).get());
        teamAthleteRepo.save(teamAthleteModel);
    }

    public void deleteTeam(Long teamId) {
        teamRepo.deleteById(teamId);
        teamAthleteRepo.deleteTeambyId(teamId);
    }
}
