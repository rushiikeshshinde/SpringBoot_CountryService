package org.example.springbootcountryserviceproject.controllers;

public class AddResponse {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String message;
    private long id;



}
