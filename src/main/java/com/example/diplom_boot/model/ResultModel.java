package com.example.diplom_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class ResultModel {
    @Id
    @Column(name = "result_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fight_id")
    private FightModel fightModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_id")
    private TeamModel winner;

    @Column(name = "score_team1")
    private Integer scoreTeam1;

    @Column(name = "score_team2")
    private Integer scoreTeam2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FightModel getFight() {
        return fightModel;
    }

    public void setFight(FightModel fightModel) {
        this.fightModel = fightModel;
    }

    public TeamModel getWinner() {
        return winner;
    }

    public void setWinner(TeamModel winner) {
        this.winner = winner;
    }

    public Integer getScoreTeam1() {
        return scoreTeam1;
    }

    public void setScoreTeam1(Integer scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public Integer getScoreTeam2() {
        return scoreTeam2;
    }

    public void setScoreTeam2(Integer scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

}