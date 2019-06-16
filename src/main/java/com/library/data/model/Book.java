package com.library.data.model;

public class Book {
    private String name;
    private Integer year;
    private String author;
    private String info;
    private Enum Language;

    public Book(String name, Integer year, String author, String info,Enum language) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.info = info;
        this.Language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Enum getLanguage() {
        return Language;
    }

    public void setLanguage(Enum language) {
        Language = language;
    }
}
