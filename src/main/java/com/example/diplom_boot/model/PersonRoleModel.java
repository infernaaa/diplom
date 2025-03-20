package com.example.diplom_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "person_role")
public class PersonRoleModel {
    @EmbeddedId
    private PersonRoleId id;

    @MapsId("personId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private PersonModelModel person;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleModel roleModel;

    public PersonRoleId getId() {
        return id;
    }

    public void setId(PersonRoleId id) {
        this.id = id;
    }

    public PersonModelModel getPerson() {
        return person;
    }

    public void setPerson(PersonModelModel person) {
        this.person = person;
    }

    public RoleModel getRole() {
        return roleModel;
    }

    public void setRole(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

}