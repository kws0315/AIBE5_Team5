package controller;

import DTO.rental;
import service.impl.rentalServiceImpl;
import service.rentalService;

import java.util.List;

public class rentalController {
    private rentalService rentalService;

    public rentalController() {
        // rentalService - new rentalServiceImpl();
    }

    // 만화채 대여
    public void rentalComic(int userId, int comicId) { }

    // 만화책 반납
    public void returnComic(int rentalId) { }

    // 대여 목록
    public List<rental> getRentalList(int userId) throws Exception {
        return null;
    }

}
