package com.example.diplom_boot.controller;


import com.example.diplom_boot.DTO.ApplicationDTO;
import com.example.diplom_boot.model.ApplicationModel;
import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.model.TournamentModel;
import com.example.diplom_boot.repository.ApplicationRepo;
import com.example.diplom_boot.repository.AthleteRepo;
import com.example.diplom_boot.repository.TeamAthleteRepo;
import com.example.diplom_boot.repository.TournamentRepo;
import com.example.diplom_boot.service.AthleteService;
import com.example.diplom_boot.service.SportClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sportclubs")
public class SportClubControl {

    private final SportClubService sportClubService;
    private final AthleteRepo athleteRepo;
    private final TournamentRepo tournamentRepo;
    private final ApplicationRepo applicationRepo;
    private final TeamAthleteRepo teamAthleteRepo;
    private final AthleteService athleteService;

    @Autowired
    public SportClubControl(SportClubService sportClubService, AthleteRepo athleteRepo, TournamentRepo tournamentRepo, ApplicationRepo applicationRepo, TeamAthleteRepo teamAthleteRepo, AthleteService athleteService) {
        this.sportClubService = sportClubService;
        this.athleteRepo = athleteRepo;
        this.tournamentRepo = tournamentRepo;
        this.applicationRepo = applicationRepo;
        this.teamAthleteRepo = teamAthleteRepo;
        this.athleteService = athleteService;
    }

    @GetMapping
    public String sportClubs(Model model) {
        model.addAttribute("SportClubs", sportClubService.findAll());
        return "sportclubs_list";
    }

    @GetMapping("/{id}")
    public String sportClubId(@PathVariable Long id, Model model) {
        model.addAttribute("sportclub", sportClubService.findById(id));
        model.addAttribute("athletes", sportClubService.findAthletesBySportClub(id));
        return "sportclub";
    }

    @GetMapping("/{id}/newApp")
    public String newApp(@PathVariable Long id, Model model) {
        List<AthleteModel> athleteList = new ArrayList<>(athleteRepo.findAthletesBySportClub(id));
        List<TournamentModel> tourList = new ArrayList<>(tournamentRepo.findAll());
        model.addAttribute("athleteList", athleteList);
        model.addAttribute("tourList", tourList);
        model.addAttribute("applicationForm", new ApplicationDTO());
        model.addAttribute("id", id);
        return "setApp";
    }

    @PostMapping("/{id}/newAppCreate")
    public String createNewApp(@PathVariable("id") String id,
                               @ModelAttribute("applicationForm") ApplicationDTO form) {
        Long newId = Long.parseLong(id);
        ApplicationModel applicationModel = new ApplicationModel();
        applicationModel.setAthlete(athleteRepo.findById(form.getAthleteId()).orElseThrow());
        applicationModel.setTeam(teamAthleteRepo.findTeamByAthleteId(form.getAthleteId()));
        applicationModel.setSportClub(sportClubService.findById(newId));
        applicationModel.setTournament(tournamentRepo.findById(form.getTourId()).orElseThrow());
        applicationModel.setStatus("PROCESSING");
        applicationModel.setApplicationDate(LocalDate.now());

        applicationRepo.save(applicationModel);
        return "redirect:/sportclubs";
    }

    @PostMapping("/{clubId}/athletes/new")
    public String addAthlete(
            @PathVariable Long clubId,
            @RequestParam String name,
            @RequestParam String bday,
            @RequestParam String rank,
            @RequestParam String category) {

        AthleteModel athlete = new AthleteModel(name, bday, rank, category, sportClubService.findById(clubId));
        athleteService.addAthleteToClub(athlete);
        return "redirect:/sportclubs/" + clubId;
    }

    @PostMapping("/{clubId}/athletes/{id}/delete")
    public String deleteAthlete(
            @PathVariable Long clubId,
            @PathVariable Long id) {
        athleteService.deleteAthlete(id);
        return "redirect:/sportclubs/" + clubId;
    }
}
