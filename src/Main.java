import config.DBconnection;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBconnection.getConnection()) {
            if (conn != null) {
                System.out.println("MySQL 연결 성공!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("MySQL 연결 실패...");
        }
    }
}