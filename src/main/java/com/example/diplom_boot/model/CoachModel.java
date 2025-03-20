package com.example.diplom_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coach")
public class CoachModel {
    @Id
    @Column(name = "coach_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private PersonModelModel person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PersonModelModel getPerson() {
        return person;
    }

    public void setPerson(PersonModelModel person) {
        this.person = person;
    }

}