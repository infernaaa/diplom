package com.example.diplom_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "athlete")
public class AthleteModel {
    @Id
    @Column(name = "athlete_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private PersonModelModel person;

    @Column(name = "rank")
    private Integer rank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryModel categoryModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PersonModelModel getPerson() {
        return person;
    }

    public void setPerson(PersonModelModel person) {
        this.person = person;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public CategoryModel getCategory() {
        return categoryModel;
    }

    public void setCategory(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

}