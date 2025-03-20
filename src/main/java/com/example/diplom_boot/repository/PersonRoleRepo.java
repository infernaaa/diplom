package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.PersonRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRoleRepo extends JpaRepository<PersonRoleModel, Long> {
}
