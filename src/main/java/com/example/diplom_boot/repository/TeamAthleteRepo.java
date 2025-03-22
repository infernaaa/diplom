package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.TeamAthleteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamAthleteRepo extends JpaRepository<TeamAthleteModel, Long> {
}
