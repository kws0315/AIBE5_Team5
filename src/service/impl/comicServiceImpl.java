package service.impl;

import DAO.comicDAO;
import DTO.comic;
import config.DBconnection;
import service.comicService;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class comicServiceImpl implements comicService {
    private comicDAO dao;

    public comicServiceImpl() throws Exception {
        Connection conn = DBconnection.getConnection();
        dao = new comicDAO(conn);
    }

    @Override
    public List<comic> getComicList() throws Exception {
        return dao.getComicList();
    }

    @Override
    public void createComic(String title, String author, String description, int series) throws Exception {
        comic c = new comic(
                0,
                title,
                author,
                description,
                series,
                new Date(System.currentTimeMillis())
        );
        dao.createComic(c);
    }

    @Override
    public void deleteComic(int comicId) throws Exception {
        dao.deleteComic(comicId);
    }

    @Override
    public comic getComicDetail(int comicId) throws Exception {
        return null;
    }
}
