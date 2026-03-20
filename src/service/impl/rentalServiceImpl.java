package service.impl;

import DAO.rentalDAO;
import DTO.rental;
import config.DBconnection;
import service.rentalService;

import java.sql.Connection;
import java.util.List;

public class rentalServiceImpl implements rentalService {
    private final rentalDAO dao;

    public rentalServiceImpl() throws Exception {
        Connection conn = DBconnection.getConnection();
        this.dao = new rentalDAO(conn);
    }

    @Override
    public boolean rentalComic(int userId, int comicId) {
        try {
            return dao.rentalComic(userId, comicId);
        } catch (Exception e) {
            System.out.println("대여 처리 중 오류: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean returnComic(int userId, int comicId) {
        try {
            return dao.returnComic(userId, comicId);
        } catch (Exception e) {
            System.out.println("반납 처리 중 오류: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<rental> getRentalList(int userId) {
        try {
            return dao.getRentalList(userId);
        } catch (Exception e) {
            return List.of();
        }
    }
}
