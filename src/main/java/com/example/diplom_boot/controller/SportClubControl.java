package com.example.diplom_boot.controller;


import com.example.diplom_boot.DTO.AthleteList;
import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.repository.AthleteRepo;
import com.example.diplom_boot.service.SportClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sportclubs")
public class SportClubControl {

    private final SportClubService sportClubService;
    private final AthleteRepo athleteRepo;

    @Autowired
    public SportClubControl(SportClubService sportClubService, AthleteRepo athleteRepo) {
        this.sportClubService = sportClubService;
        this.athleteRepo = athleteRepo;
    }

    @GetMapping
    public String sportClubs(Model model) {
        model.addAttribute("SportClubs", sportClubService.findAll());
        return "sportclubs_list";
    }

    @GetMapping("/{id}")
    public String sportClubId(@PathVariable Long id, Model model) {
        model.addAttribute("sportclub", sportClubService.findById(id));
        model.addAttribute("athletes", sportClubService.findAthletesBySportClub(id)) ;
        return "sportclub";
    }

    @GetMapping("/{id}/newApp")
    public String newApp(@PathVariable Long id, Model model) {
        List<AthleteModel> athleteList= new ArrayList<>(athleteRepo.findAthletesBySportClub(id));
        model.addAttribute("athleteList", athleteList);
        return "setApp";
    }
}
