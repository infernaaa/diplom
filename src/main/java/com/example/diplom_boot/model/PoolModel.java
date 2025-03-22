package com.example.diplom_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pool")
public class PoolModel {
    @Id
    @Column(name = "pool_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private TournamentModel tournamentModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TournamentModel getTournament() {
        return tournamentModel;
    }

    public void setTournament(TournamentModel tournamentModel) {
        this.tournamentModel = tournamentModel;
    }

}