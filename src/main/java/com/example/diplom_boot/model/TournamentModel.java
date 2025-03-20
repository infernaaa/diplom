package com.example.diplom_boot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tournament")
public class TournamentModel {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name ="tournament_id")
    private Long turnament_id;

    @Column(name = "name")
    private String turnament_name;

    @Column(name = "start_date")
    private LocalDate start_date;

    @Column(name = "end_date")
    private LocalDate end_date;

    @Column(name = "location")
    private String location;

    public String getName(){
        return turnament_name;
    }
    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public String getTurnament_name() {
        return turnament_name;
    }

    public void setTurnament_name(String turnament_name) {
        this.turnament_name = turnament_name;
    }

    public Long getTurnament_id() {
        return turnament_id;
    }

    public void setTurnament_id(Long turnament_id) {
        this.turnament_id = turnament_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
