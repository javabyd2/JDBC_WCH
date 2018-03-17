package com.sdabyd2.JDBC;

import java.sql.*;

public class App {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String DB_URL = "jdbc:mysql://127.0.0.1/rental_db?useSSL=false&serverTimezone=UTC";

    public static final String USER = "root";
    public static final String PASSWORD = "";


    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {

            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();

            String sql = "select*from customer";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("### Tabela customer ###");
            System.out.println("#######################\n");

            while (resultSet.next()) {
                System.out.println("Imie i Nazwisko:\t" + resultSet.getString("first_name") + " "
                        + resultSet.getString("last_name"));
            }

            String sqlCar = "select*from car";
            ResultSet resultSetCar = statement.executeQuery(sqlCar);
            System.out.println("\n### Tabela car ###");
            System.out.println("##################");
            System.out.println("");
            while (resultSetCar.next()) {
                System.out.println("Auto:\t" +
                        resultSetCar.getString("mark") +" "+ resultSetCar.getString("model"));
            }

            /*
            String insert = "insert into car (reg_number,mark,model,rate) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,"SI 10202");
            preparedStatement.setString(2,"Ferrair");
            preparedStatement.setString(3,"Enzo");
            preparedStatement.setString(4,"9");
            preparedStatement.executeUpdate();
            */


        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
