package com.example.untitled.DTO;

import java.sql.Date;

public class rentalDTO {
    private int rentalId;
    private int userId;
    private int comicId;
    private Date rentalDate;
    private Date returnDate;

    public rentalDTO() {}

    public rentalDTO(int rentalId, int userId, int comicId, Date rentalDate, Date returnDate) {
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
}
