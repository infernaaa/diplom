package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.ApplicationModel;
import com.example.diplom_boot.model.AthleteModel;
import com.example.diplom_boot.model.SportClubModel;
import com.example.diplom_boot.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends JpaRepository<ApplicationModel, Long> {
    @Query("SELECT s " +
            "FROM ApplicationModel a " +
            "JOIN a.sportClubModel s " +
            "WHERE a.tournamentModel.id = :tournamentId")
    List<SportClubModel> findBySportClubId(@Param("tournamentId") Long tournamentId);

    @Query("SELECT t " +
            "FROM ApplicationModel  a " +
            "JOIN a.teamModel t " +
            "WHERE a.tournamentModel.id = :tournamentId")
    List<TeamModel> findByTeamId(@Param("tournamentId") Long TeamId);

    @Query("SELECT at " +
            "FROM ApplicationModel  a " +
            "JOIN a.athleteModel at " +
            "WHERE a.tournamentModel.id = :tournamentId")
    List<AthleteModel> findByAthlete(@Param("tournamentId") Long AthleteId);
}
