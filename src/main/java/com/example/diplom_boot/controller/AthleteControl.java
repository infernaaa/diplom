package com.example.diplom_boot.controller;

import com.example.diplom_boot.service.AthleteService;
import com.example.diplom_boot.service.SportClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/athletes")
public class AthleteControl {

    private final AthleteService athleteService;
    private final SportClubService sportClubService;

    @Autowired
    AthleteControl(AthleteService athleteService, SportClubService sportClubService) {
        this.athleteService = athleteService;
        this.sportClubService = sportClubService;
    }

    @GetMapping
    public String athletes (Model model){
        model.addAttribute("athletes",athleteService.findAll());
        return "athlete_list";
    }

    @GetMapping("/{id}")
    public String athlete (@PathVariable Long id,Model model){
        model.addAttribute("athlete",athleteService.findById(id));
        return "athlete";
    }

}

