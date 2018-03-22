package com.redoxengine.exercise.appointments.api.models;

import javax.persistence.Entity;

@Entity(name = "Provider")
public class Provider extends Person {

    public Provider(){}

    public Provider(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
