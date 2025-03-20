package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.PoolModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoolRepo extends JpaRepository<PoolModel, Long> {
}
