package com.example.autentica.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TechRequest {

    @Id
    private int id;

    private String name;
    private String email;
    private String parameters;
    private String reason;
    private String Date;

    public TechRequest(int id, String name, String email, String parameters, String reason, String date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.parameters = parameters;
        this.reason = reason;
        Date = date;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public TechRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TechRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", parameters='" + parameters + '\'' +
                ", reason='" + reason + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
