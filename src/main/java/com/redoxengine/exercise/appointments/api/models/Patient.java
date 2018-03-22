package com.redoxengine.exercise.appointments.api.models;

import javax.persistence.Entity;

@Entity(name = "Patient")
public class Patient extends Person {

    public Patient(){}

    public Patient(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
