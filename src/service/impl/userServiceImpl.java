package service.impl;

import DAO.userDAO;
import DTO.user;
import config.DBconnection;
import service.userService;

import java.sql.Connection;
import java.util.List;

public class userServiceImpl implements userService {
    private final userDAO dao;

    public userServiceImpl() {
        try {
            Connection conn = DBconnection.getConnection();
            this.dao = new userDAO(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createUser(user user) throws Exception {
        dao.createUser(user);
    }

    @Override
    public void deleteUser(int userId) throws Exception {
        dao.deleteUser(userId);
    }

    @Override
    public List<user> getUserList() throws Exception {
        return dao.getUserList();
    }
}
