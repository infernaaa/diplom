package com.example.diplom_boot.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tournamentinfo")
public class TournamentInfoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id")
    private Long infoId;

    @Column(name = "tournament_id")
    private Long tournamentId;

    @Column(name = "description")
    private String description;

    @Column(name = "rules")
    private String rules;

    @Column(name = "prize_fund")
    private String prizeFund;

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(String prizeFund) {
        this.prizeFund = prizeFund;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }
}