package controllers;

import models.Order;
import utils.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderManager {
    private static OrderManager instance;

    private OrderManager() {}

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void saveOrder(Order order) {
        String query = "INSERT INTO Orders (table_number, order_details) VALUES (?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, order.getTable());
            pstmt.setString(2, order.getDetails());
            pstmt.executeUpdate();
            System.out.println("Order saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
