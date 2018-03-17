package com.sdabyd2.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection connection = null;
    private static final String ADRESS = "jdbc:mysql://127.0.0.1";
    private static final String DATABASE = "rental_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String PORT = "3306";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PARAMS = "useSSL=false&serverTimezone=UTC";



    private static void loadDriver() {
        try {
            Class.forName(DRIVER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadConnection() {
        try {
            System.out.println(getFormatedURL());
            connection = DriverManager.getConnection(getFormatedURL(), USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getFormatedURL() {
        return ADRESS + ":" + PORT + "/" + DATABASE + "?" + PARAMS;
    }

    public static Connection getConnection() {
        if (connection == null) {
            loadDriver();
            loadConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection == null) {
            System.out.println("nie ma co zamykac");
        } else {
            try {
                connection.close();
                connection = null;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
