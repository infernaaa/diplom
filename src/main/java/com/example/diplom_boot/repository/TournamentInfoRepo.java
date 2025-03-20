package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.TournamentInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentInfoRepo extends JpaRepository<TournamentInfoModel, Long> {
}
