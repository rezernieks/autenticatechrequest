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
    private String date;
    private boolean status;



    public TechRequest(int id, String name, String email, String parameters, String reason, String date, boolean status) {
        this.id = id;
        this.name = name;
        this.parameters = parameters;
        this.reason = reason;
        this.date = date;
        this.status = status;
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
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TechRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", parameters='" + parameters + '\'' +
                ", reason='" + reason + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                '}';
    }
}
