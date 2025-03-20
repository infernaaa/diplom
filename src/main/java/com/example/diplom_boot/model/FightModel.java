package com.example.diplom_boot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "fight")
public class FightModel {
    @Id
    @Column(name = "fight_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pool_id")
    private PoolModel poolModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team1_id")
    private TeamModel team1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team2_id")
    private TeamModel team2;

    @Column(name = "fight_date", nullable = false)
    private LocalDate fightDate;

    @Column(name = "fight_place", nullable = false)
    private String fightPlace;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PoolModel getPool() {
        return poolModel;
    }

    public void setPool(PoolModel poolModel) {
        this.poolModel = poolModel;
    }

    public TeamModel getTeam1() {
        return team1;
    }

    public void setTeam1(TeamModel team1) {
        this.team1 = team1;
    }

    public TeamModel getTeam2() {
        return team2;
    }

    public void setTeam2(TeamModel team2) {
        this.team2 = team2;
    }

    public LocalDate getFightDate() {
        return fightDate;
    }

    public void setFightDate(LocalDate fightDate) {
        this.fightDate = fightDate;
    }

    public String getFightPlace() {
        return fightPlace;
    }

    public void setFightPlace(String fightPlace) {
        this.fightPlace = fightPlace;
    }

}