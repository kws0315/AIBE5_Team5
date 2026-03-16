package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/team5?serverTimezone=Asia/Seoul";
    private static final String USER = "root";
    private static final String PASSWORD = "kol52395";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}