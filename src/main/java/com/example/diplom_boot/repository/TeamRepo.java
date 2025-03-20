package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<TeamModel, Long> {
}
