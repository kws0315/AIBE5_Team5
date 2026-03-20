package DAO;

import DTO.rental;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class rentalDAO {
    private Connection con;
    public rentalDAO() {}
    public rentalDAO(Connection con) { this.con = con; }

    private boolean existsUser(int userId) throws SQLException {
        String sql = "SELECT 1 FROM user WHERE user_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private boolean existsComic(int comicId) throws SQLException {
        String sql = "SELECT 1 FROM comic WHERE comic_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, comicId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    // 만화 대여
    public boolean rentalComic(int userId, int comicId) throws SQLException {
        String checkSql = "SELECT 1 FROM rental WHERE comic_id = ? AND returnDate IS NULL";
        String sql = "INSERT INTO rental (user_id, comic_id, rentalDate, returnDate) VALUES (?, ?, CURRENT_DATE, null)";

        if (!existsUser(userId)) {
            System.out.println("대여 실패: 존재하지 않는 userId 입니다. (" + userId + ")");
            return false;
        }

        if (!existsComic(comicId)) {
            System.out.println("대여 실패: 존재하지 않는 comicId 입니다. (" + comicId + ")");
            return false;
        }

        try (PreparedStatement checkStmt = con.prepareStatement(checkSql)) {
            checkStmt.setInt(1, comicId);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("대여 실패: 이미 대여 중인 만화입니다. (" + comicId + ")");
                    return false;
                }
            }
        }

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, comicId);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("대여 성공: 사용자 " + userId + "님이 " + comicId + "번 만화를 대여했습니다.");
                return true;
            }
        }
        return false;
    }

    // 만화 반납 (returnDate 업데이트)
    public boolean returnComic(int userId, int comicId) throws SQLException {
        String sql = "UPDATE rental SET returnDate = CURRENT_DATE WHERE user_id = ? AND comic_id = ? AND returnDate IS NULL";

        if (!existsUser(userId) || !existsComic(comicId)) {
            return false;
        }

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, comicId);

            int result = pstmt.executeUpdate();
            return result > 0;
        }
    }

    // 대여 목록 조회
    public List<rental> getRentalList(int userId) throws SQLException {
        String sql = "SELECT r.rental_id, c.title, c.author, c.series, r.rentalDate, r.returnDate " +
                    "FROM rental r " +
                    "JOIN comic c ON r.comic_id = c.comic_id " +
                    "WHERE r.user_id = ? " +
                    "ORDER BY r.rentalDate DESC, r.rental_id DESC";
        List<rental> list = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try(ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    rental r = new rental();

                    // rental 정보 매핑
                    r.setRentalId(rs.getInt("rental_id"));
                    r.setRentalDate(rs.getDate("rentalDate"));
                    r.setReturnDate(rs.getDate("returnDate"));

                    // comic 정보 매핑 (rental DTO에 해당 필드들이 있어야 합니다)
                    // 만약 DTO에 필드가 없다면 추가하시거나 별도의 Map 등을 사용해야 합니다.
                    r.setTitle(rs.getString("title"));
                    r.setAuthor(rs.getString("author"));
                    r.setSeries(rs.getInt("series"));

                    list.add(r);
                }
            }
        }

        return list;
    }
}
