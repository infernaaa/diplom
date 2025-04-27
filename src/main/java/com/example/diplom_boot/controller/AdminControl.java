package com.example.diplom_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminControl {
    @GetMapping
    public String index() {
        return "indexAdmin";
    }


    @PostMapping("test")
    public void test(){
        System.out.println("test");
    }
}
