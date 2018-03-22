package com.redoxengine.exercise.appointments.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity(name = "Webhook")
public class Webhook {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="url")
    private String url;

    @Column(name="company_name")
    private String companyName;


    public Webhook() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Webhook(Long id, String url, String companyName, String type) {
        super();
        this.id = id;
        this.url = url;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}