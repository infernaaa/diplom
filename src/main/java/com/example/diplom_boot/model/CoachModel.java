package com.example.diplom_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coach")
public class CoachModel {
    @Id
    @Column(name = "coach_id", nullable = false)
    private Long id;

    @Column(name = "fio", length = 50)
    private String fio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

}