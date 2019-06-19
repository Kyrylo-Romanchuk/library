package com.library.data.model;

import java.util.Date;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String biography;
    private Date birthDay;
    private Date dieDay;

    public Author() {
    }

    public Author(int id, String firstName, String lastName, String biography, Date birthDay, Date dieDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.birthDay = birthDay;
        this.dieDay = dieDay;
        this.fullName = firstName + " " + lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getDieDay() {
        return dieDay;
    }

    public void setDieDay(Date dieDay) {
        this.dieDay = dieDay;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
