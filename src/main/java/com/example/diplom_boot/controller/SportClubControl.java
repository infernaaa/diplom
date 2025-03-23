package com.example.diplom_boot.controller;


import com.example.diplom_boot.service.SportClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sportclubs")
public class SportClubControl {

    private final SportClubService sportClubService;

    @Autowired
    public SportClubControl(SportClubService sportClubService) {
        this.sportClubService = sportClubService;
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


}
