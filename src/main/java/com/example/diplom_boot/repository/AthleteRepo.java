package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.AthleteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepo extends JpaRepository<AthleteModel, Long> {
}
