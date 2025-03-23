package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.SportClubModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportClubRepo extends JpaRepository<SportClubModel, Long> {

}
