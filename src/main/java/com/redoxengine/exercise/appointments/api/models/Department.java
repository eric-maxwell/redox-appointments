package com.redoxengine.exercise.appointments.api.models;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table
public class Department {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Department(){}

    public Department(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
