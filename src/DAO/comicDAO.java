package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DTO.comic;


public class comicDAO {
    private Connection conn;
    public comicDAO() {}
    public comicDAO(Connection conn) {
        this.conn = conn;
    }

    // 만화책 입력
    public void createComic(comic c) throws SQLException {
        String sql = "INSERT INTO comic (title, author, description, series, comic_regDate) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, c.getTitle());
            pstmt.setString(2, c.getAuthor());
            pstmt.setString(3, c.getDescription());
            pstmt.setInt(4, c.getSeries());
            pstmt.setDate(5, c.getComicRegDate());

            int result = pstmt.executeUpdate();

            // 생성된 ID 가져오기
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    c.setComicId(generatedId);
                }
            }

            if (result > 0) {
                System.out.println("등록 성공: " + c.getTitle() + " (ID=" + c.getComicId() + ")");
            } else {
                System.out.println("등록 실패");
            }

        }
    } // create comic 끝

    // 만화책 목록 조회
    public List<comic> getComicList() throws SQLException {
        List<comic> list = new ArrayList<>();
        String sql = "SELECT * FROM comic";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                comic c = new comic(
                        rs.getInt("comic_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("description"), // 만화책 목록 조회할 때는 사용하지 않기
                        rs.getInt("series"),
                        rs.getDate("comic_regDate")
                );
                list.add(c);
            }
        }
        return list;
    } // 목록 조회 끝

    public void deleteComic(int comicId) throws SQLException {
        String sql = "DELETE FROM comic WHERE comic_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, comicId);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("삭제 성공 (ID=" + comicId + ")");
            } else {
                System.out.println("해당 ID의 만화가 없습니다.");
            }
        }
    }

    public comic getComicDetail(int comicId) throws SQLException {
        String sql = "SELECT * FROM comic WHERE comic_id = ?";
        comic c = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, comicId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    c = new comic(
                            rs.getInt("comic_id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getString("description"),
                            rs.getInt("series"),
                            rs.getDate("comic_regDate")
                    );
                }
            }
        }
        return c;
    }

} // 클래스 끝
