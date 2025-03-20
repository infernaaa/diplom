package com.example.diplom_boot.repository;

import com.example.diplom_boot.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryModel, Long> {
}
