package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.AthleteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepo extends JpaRepository<AthleteModel, Long> {
    @Query("select at " +
            "from AthleteModel at " +
            "where at.idClub.id = :idClub")
    List<AthleteModel> findAthletesBySportClub(@Param("idClub") Long idClub);
}
