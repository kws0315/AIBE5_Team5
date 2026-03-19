package DAO;

import DTO.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class userDAO {
    private Connection con;
    public userDAO() {}
    public userDAO(Connection con) { this.con = con; }

    public void createUser(user user) throws SQLException {
        String sql = "INSERT INTO user (name, user_regDate) VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getName());
            pstmt.setDate(2, user.getUserRegDate());

            int result = pstmt.executeUpdate();
            if (result > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        user.setUserId(rs.getInt(1));
                    }
                }
                System.out.println("회원 등록 성공: " + user.getName() + " (ID=" + user.getUserId() + ")");
            } else {
                System.out.println("회원 등록 실패");
            }
        }
    }

    public void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM user WHERE user_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("회원 삭제 성공 (ID=" + userId + ")");
            } else {
                System.out.println("해당 ID의 회원이 없습니다.");
            }
        }
    }

    public List<user> getUserList() throws SQLException {
        String sql = "SELECT user_id, name, user_regDate FROM user ORDER BY user_id";
        List<user> list = new ArrayList<>();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                user u = new user(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getDate("user_regDate")
                );
                list.add(u);
            }
        }
        return list;
    }
}
