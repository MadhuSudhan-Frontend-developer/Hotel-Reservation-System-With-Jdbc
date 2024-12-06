package com.projectJdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Pwd";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
    }
}
