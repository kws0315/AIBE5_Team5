package service;

import java.sql.Date;
import java.util.List;

import DTO.rental;

public interface rentalService {
    // 만화 대여
    boolean rentalComic(int userId, int comicId);

    // 만화 반납 (returnDate가 null이면 대여만 한 상태)
    boolean returnComic(int userId, int comicId);

    // 대여 목록 조회
    List<rental> getRentalList(int userId);
}
