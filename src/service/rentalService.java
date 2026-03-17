package service;

import java.sql.Date;
import java.util.List;

import DTO.rental;

public interface rentalService {
    // 만화 대여
    void rentalComic(int comicId, int userId);

    // 만화 반납 (returnDate가 null이면 대여만 한 상태)
    int returnComic(int rentalId, Date returnDate);

    // 대여 목록 조회
    List<rental> getRentalList();
}
