package com.example.BotCreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        //dbTestConnection();
        SpringApplication.run(ServerApplication.class, args);
    }


    private static void dbTestConnection() {
        String url = "jdbc:postgresql://localhost:5432/";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "2318201");
        props.setProperty("ddl", "true");
        try {
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("dbTestConnection!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
