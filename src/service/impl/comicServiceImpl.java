package service.impl;

import DAO.comicDAO;
import DTO.comic;
import config.DBconnection;
import service.comicService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class comicServiceImpl implements comicService {

    @Override
    public void createComic(String title, String author, String description, int series) throws Exception {
        // Controller가 보내준 데이터를 하나의 DTO로 포장 (현재 시스템 날짜 포함)
        Date currentDate = new Date(System.currentTimeMillis());
        comic newComic = new comic(title, author, description, series, currentDate);

        // DB 연결선 열기
        try (Connection conn = DBconnection.getConnection()) {
            // DAO에게 연결선 쥐어주고 생성 지시
            comicDAO dao = new comicDAO(conn);
            dao.createComic(newComic);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("만화책 등록 중 DB 오류가 발생했습니다.");
        }
    }

    @Override
    public List<comic> getComicList() throws Exception {
        try (Connection conn = DBconnection.getConnection()) {
            comicDAO dao = new comicDAO(conn);
            return dao.getComicList();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("만화책 목록 조회 중 DB 오류가 발생했습니다.");
        }
    }

    @Override
    public comic getComicDetail(int comicId) throws Exception {
        try (Connection conn = DBconnection.getConnection()) {
            comicDAO dao = new comicDAO(conn);
            return dao.getComicDetail(comicId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("만화책 상세내용 조회 중 DB 오류가 발생했습니다.");
        }
    }

    @Override
    public boolean deleteComic(int comicId) throws Exception {
        try (Connection conn = DBconnection.getConnection()) {
            comicDAO dao = new comicDAO(conn);
            // 현재 DAO의 deleteComic은 반환값이 void이지만 예외 없이 끝나면 true를 반환하도록 설계
            dao.deleteComic(comicId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            // DB 삭제 실패 시 false 반환
            return false;
        }
    }
}
