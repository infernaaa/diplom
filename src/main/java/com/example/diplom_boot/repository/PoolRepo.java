package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.PoolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PoolRepo extends JpaRepository<PoolModel, Long> {
}
