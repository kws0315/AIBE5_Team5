package DTO;

import java.sql.Date;

public class comic {
    private int comicId;
    private String title;
    private String author;
    private String description;
    private int series;
    private Date comic_regDate;

    public comic() {}

    public comic(int comicId, String title, String author, String description, int series, Date comicRegDate) {
        this.comicId = comicId;
        this.title = title;
        this.author = author;
        this.description = description;
        this.series = series;
        this.comic_regDate = comicRegDate;
    }

    public comic(String title, String author, String description, int series, Date comicRegDate) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.series = series;
        this.comic_regDate = comicRegDate;
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
        return comic_regDate;
    }

    public void setComicRegDate(Date comicRegDate) {
        this.comic_regDate = comicRegDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
