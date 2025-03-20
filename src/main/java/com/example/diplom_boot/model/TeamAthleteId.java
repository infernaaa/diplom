package com.example.diplom_boot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class TeamAthleteId implements java.io.Serializable {
    private static final long serialVersionUID = -3646968387003611499L;
    @Column(name = "team_id", nullable = false)
    private Integer teamId;

    @Column(name = "athlete_id", nullable = false)
    private Integer athleteId;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Integer athleteId) {
        this.athleteId = athleteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TeamAthleteId entity = (TeamAthleteId) o;
        return Objects.equals(this.athleteId, entity.athleteId) &&
                Objects.equals(this.teamId, entity.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(athleteId, teamId);
    }

}