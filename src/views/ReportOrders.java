package views;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import utils.Database;
import models.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportOrders {
    public static void display() {
        Stage stage = new Stage();
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px;");

        // ListView to display orders
        ListView<String> orderListView = new ListView<>();
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT table_number, order_details, paid FROM Orders")) {

            while (rs.next()) {
                String table = rs.getString("table_number");
                String details = rs.getString("order_details");
                String paidStatus = rs.getInt("paid") == 1 ? "Paid" : "Unpaid";
                orderListView.getItems().add("Table: " + table + ", Details: " + details + ", Status: " + paidStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        root.getChildren().add(orderListView);
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Order Report");
        stage.setScene(scene);
        stage.show();
    }
}
