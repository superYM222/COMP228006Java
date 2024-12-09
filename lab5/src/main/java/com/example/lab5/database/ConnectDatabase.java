package com.example.lab5.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {


        


        public static Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC 드라이버 로드
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.err.println("JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("데이터베이스 연결 오류: " + e.getMessage());
            }
            return connection;
        }


}


