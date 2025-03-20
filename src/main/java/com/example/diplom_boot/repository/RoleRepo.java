package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleModel, Long> {
}
