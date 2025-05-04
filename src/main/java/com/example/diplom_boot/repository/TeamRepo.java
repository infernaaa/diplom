package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepo extends JpaRepository<TeamModel, Long> {
    @Query("select team " +
            "from TeamModel team " +
            "where team.sportClubModel = :sportClubId")
    List<TeamModel> getTeamModelBySportClubID(@Param("sportClubId")Long sportClubId);
}
