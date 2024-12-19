package utils;

import models.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    // Fetch unpaid orders
    public static List<Order> getUnpaidOrders() {
        List<Order> unpaidOrders = new ArrayList<>();
        String query = "SELECT id, table_number, order_details FROM Orders WHERE paid = 0";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                unpaidOrders.add(new Order(
                        rs.getInt("id"),
                        rs.getString("table_number"),
                        rs.getString("order_details")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unpaidOrders;
    }

    // Mark an order as paid
    public static void markAsPaid(int orderId) {
        String query = "UPDATE Orders SET paid = 1 WHERE id = ?";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
