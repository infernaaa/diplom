package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.ApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepo extends JpaRepository<ApplicationModel, Long> {
    @Query("SELECT a.sportClub.idSportClub " +
            "FROM ApplicationModel  a " +
            "WHERE a.sportClub.idSportClub = :tournamentId")
    List<Long> findBySportClubId(@Param("tournamentId") Long sportClubId);

    @Query("SELECT a.teamModel.id " +
            "FROM ApplicationModel  a " +
            "WHERE a.teamModel.id = :tournamentId")
    List<Long> findByTeamId(@Param("tournamentId") Long TeamId);

    @Query("SELECT a.athleteModel.id " +
            "FROM ApplicationModel  a " +
            "WHERE a.athleteModel.id = :tournamentId")
    List<Long> findByAthlete(@Param("tournamentId") Long AthleteId);
}
