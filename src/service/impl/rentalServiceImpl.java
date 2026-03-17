package service.impl;

import DTO.rental;
import service.rentalService;

import java.sql.Date;
import java.util.List;

public class rentalServiceImpl implements rentalService {
    @Override
    public void rentalComic(int comicId, int userId) {

    }

    @Override
    public int returnComic(int rentalId, Date returnDate) {
        return 0;
    }

    @Override
    public List<rental> getRentalList() {
        return List.of();
    }
}
