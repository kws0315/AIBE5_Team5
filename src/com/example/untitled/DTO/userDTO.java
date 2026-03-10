package com.example.untitled.DTO;

import java.sql.Date;

public class userDTO {
    private int userId;
    private String name;
    private Date userRegDate;

    public userDTO() {}

    public userDTO(int userId, String name, Date userRegDate) {
        this.userId = userId;
        this.name = name;
        this.userRegDate = userRegDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getUserRegDate() {
        return userRegDate;
    }

    public void setUserRegDate(Date userRegDate) {
        this.userRegDate = userRegDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
