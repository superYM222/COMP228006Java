package com.example.lab5.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {


        private static final String URL = "jdbc:oracle1.centennialcollege.ca:199.212.26.208:1521:SQLD"; // 변경: DB 호스트, 포트, SID
        private static final String USERNAME = "COMP228_F24_soh_18"; // 변경: DB 사용자 이름
        private static final String PASSWORD = "password1"; // 변경: DB 비밀번호


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


