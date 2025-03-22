package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.AthleteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepo extends JpaRepository<AthleteModel, Long> {
}
