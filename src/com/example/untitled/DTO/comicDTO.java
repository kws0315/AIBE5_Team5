package com.example.untitled.DTO;

import java.sql.Date;

public class comicDTO {
    private int comicId;
    private String title;
    private String author;
    private String description;
    private int series;
    private Date comicRegDate;

    public comicDTO() {}

    public comicDTO(int comicId, String title, String author, String description, int series, Date comicRegDate) {
        this.comicId = comicId;
        this.title = title;
        this.author = author;
        this.description = description;
        this.series = series;
        this.comicRegDate = comicRegDate;
    }
    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public Date getComicRegDate() {
        return comicRegDate;
    }

    public void setComicRegDate(Date comicRegDate) {
        this.comicRegDate = comicRegDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
