package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.model.TeamAthleteModel;
import com.example.diplom_boot.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamAthleteRepo extends JpaRepository<TeamAthleteModel, Long> {
    @Query("select ta.teamModel " +
            "from TeamAthleteModel ta " +
            "where ta.athleteModel.id = :athleteId")
    TeamModel findTeamByAthleteId(@Param("athleteId") Long athleteId);

    @Query("SELECT a " +
            "FROM TeamAthleteModel ta " +
            "LEFT JOIN ta.athleteModel a " +
            "LEFT JOIN ta.teamModel m " +
            "WHERE ta.teamModel.id = :teamId")
    List<AthleteModel> findMembersByTeamId(@Param("teamId") Long teamId);

    @Query("delete from TeamAthleteModel " +
            "where teamModel= :teamId")
    void deleteTeambyId(@Param("teamId") Long teamId);

    @Query("delete from TeamAthleteModel " +
            "where athleteModel= :athleteId")
    void deleteAthleteFromTeam(@Param("athleteId") Long athleteId);
}
