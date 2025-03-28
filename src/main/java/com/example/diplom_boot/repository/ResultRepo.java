package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.ResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ResultRepo extends JpaRepository<ResultModel, Long> {
}
