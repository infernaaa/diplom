package com.example.diplom_boot.controller;

import com.example.diplom_boot.service.ApplicatonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class ApplicationControl {

    private final ApplicatonService applicatonService;

    @Autowired
    public ApplicationControl(ApplicatonService applicatonService) {
        this.applicatonService = applicatonService;
    }
    @GetMapping
    public String getAllApplications(Model model) {
        model.addAttribute("applicationsDTO", applicatonService.getAllApplications());
        return "application";
    }
}
