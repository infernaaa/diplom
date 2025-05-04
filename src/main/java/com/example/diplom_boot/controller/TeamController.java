package com.example.diplom_boot.controller;

import com.example.diplom_boot.model.TeamModel;
import com.example.diplom_boot.repository.CoachRepo;
import com.example.diplom_boot.repository.SportClubRepo;
import com.example.diplom_boot.repository.TeamAthleteRepo;
import com.example.diplom_boot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;
    private final CoachRepo coachRepo;
    private final SportClubRepo sportClubRepo;
    private final TeamAthleteRepo teamAthleteRepo;

    @Autowired
    public TeamController(TeamService teamService, CoachRepo coachRepo, SportClubRepo sportClubRepo, TeamAthleteRepo teamAthleteRepo) {
        this.teamService = teamService;
        this.coachRepo = coachRepo;
        this.sportClubRepo = sportClubRepo;
        this.teamAthleteRepo = teamAthleteRepo;
    }

    @GetMapping
    public String teams(Model model) {
        model.addAttribute("teams", teamService.findAllTeams());
        return "teams";
    }

    @GetMapping("/{id}")
    public String teamDetail(Model model, @PathVariable Long id) {
        model.addAttribute("team", teamService.findTeamById(id));
        model.addAttribute("teamMembers", teamService.findMembersByTeamId(id));
        return "team";
    }

    @PostMapping("/create")
    public String createNewTeam(Model model,
                                @RequestParam String sportClubId,
                                @RequestParam String coachId,
                                @RequestParam String name) {
        TeamModel teamModel = new TeamModel(
                sportClubRepo.findById(Long.parseLong(sportClubId)).get(),
                coachRepo.findById(Long.parseLong(coachId)).get(),
                name);
        teamService.save(teamModel);
        return "redirect:/teams";
    }

    @PostMapping("/{id}/add")
    public String addAthleteToTeam(@PathVariable Long id, Model model,
                                   @RequestParam String athleteId) {
        teamService.addAthleteToTeam(id, Long.parseLong(athleteId));
        return "redirect:/teams" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return "redirect:/teams";
    }

    @PostMapping("/{id}/deleteAthlete")
    public String deleteAthleteFromTeam(@PathVariable Long id,
                                        @RequestParam String athleteId) {
        teamAthleteRepo.deleteAthleteFromTeam(Long.parseLong(athleteId));
        return "redirect:/teams" + id;
    }
}
