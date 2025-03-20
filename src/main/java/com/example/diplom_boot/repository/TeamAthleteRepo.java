package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.TeamAthleteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamAthleteRepo extends JpaRepository<TeamAthleteModel, Long> {
}
