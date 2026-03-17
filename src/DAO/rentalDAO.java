package DAO;

import DTO.rental;
import java.sql.Date;
import java.sql.Connection;
import java.util.List;

public class rentalDAO {
    private Connection con;
    public rentalDAO() {}
    public rentalDAO(Connection con) { this.con = con; }

    // 만화 대여
    public void rentalComic(rental rental) { }

    // 만화 반납 (returnDate 업데이트)
    public void returnComic(int rentalId, Date returnDate) { }

    // 대여 목록 조회
    public List<rental> getRentalList() {
        return null;
    }
}
