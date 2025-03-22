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
    private TeamModel teamModel1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team2_id")
    private TeamModel teamModel2;

    @Column(name = "fight_date")
    private LocalDate fightDate;

    @Column(name = "fight_place")
    private LocalDate fightPlace;

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
        return teamModel1;
    }

    public void setTeam1(TeamModel teamModel1) {
        this.teamModel1 = teamModel1;
    }

    public TeamModel getTeam2() {
        return teamModel2;
    }

    public void setTeam2(TeamModel teamModel2) {
        this.teamModel2 = teamModel2;
    }

    public LocalDate getFightDate() {
        return fightDate;
    }

    public void setFightDate(LocalDate fightDate) {
        this.fightDate = fightDate;
    }

    public LocalDate getFightPlace() {
        return fightPlace;
    }

    public void setFightPlace(LocalDate fightPlace) {
        this.fightPlace = fightPlace;
    }

}