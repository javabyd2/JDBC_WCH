package com.sdabyd2.JDBC;

import java.sql.*;

public class App {

    public static void main(String[] args) {

        Connection connection = DBConnector.getConnection();
        Statement statement = null;



        try  {

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

            String sqlUpdate = "UPDATE rental_db.car SET model='Corsa' WHERE reg_number='SL 23457';\n";
            statement.executeUpdate(sqlUpdate);



        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
