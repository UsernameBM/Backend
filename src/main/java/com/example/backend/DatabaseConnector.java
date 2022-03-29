package com.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "movie";
        String databaseUser = "root";
        String databasePassword = "password123";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
