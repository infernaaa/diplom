package com.example.diplom_boot.controller;

import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.service.AthleteService;
import com.example.diplom_boot.service.SportClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AthleteControl {
    AthleteService athleteService;
    SportClubService sportClubService;
    @Autowired
    AthleteControl(AthleteService athleteService, SportClubService sportClubService) {
        this.athleteService = athleteService;
        this.sportClubService = sportClubService;
    }
    @Controller
    public class AthleteController {

        @PostMapping("/sportclubs/{clubId}/athletes/new")
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

        @PostMapping("/sportclubs/{clubId}/athletes/{id}/delete")
        public String deleteAthlete(
                @PathVariable Long clubId,
                @PathVariable Long id) {
            athleteService.deleteAthlete(id);
            return "redirect:/sportclubs/" + clubId;
        }
    }
}
