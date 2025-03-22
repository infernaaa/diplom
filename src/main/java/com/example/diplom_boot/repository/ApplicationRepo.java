package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.ApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends JpaRepository<ApplicationModel, Long> {
    @Query("SELECT a.sportClubModel.id " +
            "FROM ApplicationModel  a " +
            "WHERE a.sportClubModel.id = :tournamentId")
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
