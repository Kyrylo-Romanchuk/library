package com.library.model;

public class Book {
    private String name;
    private Integer year;
    private String author;
    private String bookInfo;
    private Enum Language;

    public Book(String name, Integer year, String author, Enum language) {
        this.name = name;
        this.year = year;
        this.author = author;
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

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Enum getLanguage() {
        return Language;
    }

    public void setLanguage(Enum language) {
        Language = language;
    }
}
