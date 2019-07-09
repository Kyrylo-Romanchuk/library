package com.library.data.dto;

import java.util.Date;

public class AuthorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String biography;
    private Date birthDay;
    private Date dieDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
