package org.example.airport_management_system.connections;

import java.io.*;
import java.sql.*;
import java.util.Scanner;


public class Connections{
    private static final String URL = "jdbc:postgresql://localhost:5432/AirportManagementSystem";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "h01112002";

    private static Connection connection;


    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void closeConnection() {
        if (connection == null) {
            throw new NullPointerException("Connection is null:");
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public  void readFromCompanyTxt() {

        try {
            getConnection();
            File file = new File("C:/Users/asus/Desktop/homework_JDBC/companies.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                    String[] dateList = line.split(",");
                    String a1 = dateList[0];
                    String a2 = dateList[1];
                    PreparedStatement pst = connection.prepareStatement("INSERT INTO company (company_name, founding_date) VALUES(?,?)");
                    pst.setString(1, a1);
                    pst.setString(2, a2);
                line = reader.readLine();
                pst.executeUpdate();
        }
            closeConnection();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public  void readFromPassengersTxt() {

        try {
            getConnection();
            File file = new File("C:/Users/asus/Desktop/homework_JDBC/passengers.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] dateList = line.split(",");
                String a1 = dateList[0];
                String a2 = dateList[1];
                String a3 = dateList[2];
                String a4 = dateList[3];
                PreparedStatement pst = connection.prepareStatement("INSERT INTO passengerss (passenger_name, passenger_phone,country, city) VALUES(?,?,?,?)");
                pst.setString(1, a1);
                pst.setString(2, a2);
                pst.setString(3, a3);
                pst.setString(4, a4);
                line = reader.readLine();
                pst.executeUpdate();
            }
            closeConnection();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public  void readFromTripTxt() {

        try {
            getConnection();
            File file = new File("C:/Users/asus/Desktop/homework_JDBC/trip.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] dateList = line.split(",");
                String a1 = dateList[0];
                String a2 = dateList[1];
                String a3 = dateList[2];
                String a4 = dateList[3];
                String a5 = dateList[4];
                String a6 = dateList[5];
                String a7 = dateList[6];
                PreparedStatement pst = connection.prepareStatement("INSERT INTO trip (trip_id,airplane_name,town_from,town_to,time_out,time_in) VALUES(?,?,?,?,?,?,?)");
                pst.setInt(1, Integer.parseInt(a1));
                pst.setInt(2, Integer.parseInt(a2));
                pst.setString(3, a3);
                pst.setString(4, a4);
                pst.setString(5, a5);
                pst.setString(6, a6);
                pst.setString(7, a7);
                line = reader.readLine();
                pst.executeUpdate();
            }
            closeConnection();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
