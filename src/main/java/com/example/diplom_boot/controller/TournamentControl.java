package com.example.diplom_boot.controller;

import com.example.diplom_boot.DTO.TournamentDTO;
import com.example.diplom_boot.repository.TournamentRepo;
import com.example.diplom_boot.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tournament")
public class TournamentControl {

    private final TournamentService tournamentService;

    @Autowired
    public TournamentControl(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }


    @GetMapping
    public String tournament(Model model) {
        model.addAttribute("tournamentModel", tournamentService.findAll());
        return "tournaments";
    }

    @GetMapping("/{id}")
    public String tournament(@PathVariable Long id, Model model) {
        model.addAttribute("TournamentDTO",tournamentService.findInfo(id));
        return "tournamentInfo.html";
    }
}
