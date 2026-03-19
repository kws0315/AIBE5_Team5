package DTO;

import java.sql.Date;

public class rental {
    private int rentalId;
    private int userId;
    private int comicId;
    private String title;
    private String author;
    private int series;
    private Date rentalDate;
    private Date returnDate;

    public rental() {}

    public rental(int rentalId, int userId, int comicId, Date rentalDate, Date returnDate) {
        this.rentalId = rentalId;
        this.userId = userId;
        this.comicId = comicId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return String.format(
                "rentalId=%d, title=%s, author=%s, series=%d, rentalDate=%s, returnDate=%s",
                rentalId, title, author, series, rentalDate, returnDate
        );
    }
}
