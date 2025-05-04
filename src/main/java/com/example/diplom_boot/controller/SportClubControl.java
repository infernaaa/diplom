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
import com.example.diplom_boot.service.TeamService;
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
    private final TeamService teamService;
    private final TeamController teamController;

    @Autowired
    public SportClubControl(SportClubService sportClubService, AthleteRepo athleteRepo, TournamentRepo tournamentRepo, ApplicationRepo applicationRepo, TeamAthleteRepo teamAthleteRepo, AthleteService athleteService, TeamService teamService, TeamController teamController) {
        this.sportClubService = sportClubService;
        this.athleteRepo = athleteRepo;
        this.tournamentRepo = tournamentRepo;
        this.applicationRepo = applicationRepo;
        this.teamAthleteRepo = teamAthleteRepo;
        this.athleteService = athleteService;
        this.teamService = teamService;
        this.teamController = teamController;
    }

    @GetMapping
    public String sportClubs(Model model) {
        model.addAttribute("SportClubs", sportClubService.findAll());
        return "sportclubs_list";
    }

    /**
     * Просмотр детальной информации о клубе
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public String sportClubId(@PathVariable Long id, Model model) {
        model.addAttribute("sportclub", sportClubService.findById(id));
        model.addAttribute("athletes", sportClubService.findAthletesBySportClub(id));
        return "sportclub";
    }

    @PostMapping("/{id}/delete")
    public String deleteSportClub(@PathVariable Long id, Model model) {
        sportClubService.deleteById(id);
        return "redirect:/sportclubs" + id;
    }

    /**
     * end point на просмотр команд клуба
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}/teams")
    public String teamsSportClub(@PathVariable Long id, Model model) {
        model.addAttribute("Teams", teamService.findTeamBySportlubId(id));
        return "teamsSportClub";
    }

    @GetMapping("/{id}/teams/{teamId}")
    public String teamsSportClubDetail(@PathVariable Long id, @PathVariable Long teamId, Model model) {
        model.addAttribute("team", teamService.findTeamById(teamId));
        model.addAttribute("teamMembers", teamService.findMembersByTeamId(teamId));
        return "teamsSportClubDetail";
    }

    /**
     * Запрос на создание новой команды от клуба
     *
     * @param id
     * @param coachId
     * @param name
     * @param model
     * @return
     */
    @PostMapping("/{id}/createTeam")
    public String createTeam(@PathVariable Long id,
                             @RequestParam String coachId,
                             @RequestParam String name,
                             Model model) {
        teamService.save(id, Long.parseLong(coachId), name);
        return "redirect:/sportclubs/" + id;
    }

    /**
     * end point на создание новой заявки от клуба
     *
     * @param id
     * @param model
     * @return
     */
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

    /**
     * Создание новой заявки от клуба
     *
     * @param id   клуба
     * @param form DTO для заявки
     * @return переадресация на исходную, обращение в бд с записью заявки
     */
    @PostMapping("/{id}/newAppCreate")
    public String createNewApp(@PathVariable("id") String id,
                               @ModelAttribute("applicationForm") ApplicationDTO form) {
        Long newId = Long.parseLong(id);
        ApplicationModel applicationModel = new ApplicationModel();
        applicationModel.setAthlete(athleteRepo.findById(form.getAthlete().getId()).orElseThrow());
        applicationModel.setTeam(teamAthleteRepo.findTeamByAthleteId(form.getAthlete().getId()));
        applicationModel.setSportClub(sportClubService.findById(newId));
        applicationModel.setTournament(tournamentRepo.findById(form.getTour().getId()).orElseThrow());
        applicationModel.setStatus("PROCESSING");
        applicationModel.setApplicationDate(LocalDate.now());

        applicationRepo.save(applicationModel);
        return "redirect:/sportclubs";
    }

    /**
     * Создание нового спортсмена в клубе
     *
     * @param clubId   клуб
     * @param name     имя спортика
     * @param bday     др спортика
     * @param rank     ранг спортика
     * @param category категория (возраста) спортика
     * @return переадресация на форму раньше, добавление спортика в клуб (БД)
     */
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

    /**
     * Удаление спортика из клуба и вообще
     *
     * @param clubId id клуба
     * @param id     id спортика
     * @return переадресация на страницу, удаление из бд
     */
    @PostMapping("/{clubId}/athletes/{id}/delete")
    public String deleteAthlete(
            @PathVariable Long clubId,
            @PathVariable Long id) {
        athleteService.deleteAthlete(id);
        return "redirect:/sportclubs/" + clubId;
    }
}
