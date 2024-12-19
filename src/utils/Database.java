package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:sqlite:/Users/Tariq/Downloads/CodingSpace/RestaurantManagementSystem/src/resources/restaurant.db";

    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Connected to the database!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Database connection failed! Path: " + URL);
            e.printStackTrace();
            return null;
        }
    }
}
