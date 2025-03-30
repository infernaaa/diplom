package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.TeamAthleteModel;
import com.example.diplom_boot.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamAthleteRepo extends JpaRepository<TeamAthleteModel, Long> {
    @Query("select ta.teamModel " +
            "from TeamAthleteModel ta " +
            "where ta.athleteModel.id = :athleteId")
    TeamModel findTeamByAthleteId(@Param("athleteId")Long athleteId);
}
