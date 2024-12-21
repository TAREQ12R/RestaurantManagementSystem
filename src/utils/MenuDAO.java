package utils;

import models.MenuItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO extends MenuSubject {

    // Method to fetch menu items from the database
    public static List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        try (Connection conn = Database.connect()) {
            String query = "SELECT name, category, price FROM MenuItems";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set and map it to MenuItem objects
            while (rs.next()) {
                menuItems.add(new MenuItem(
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuItems;
    }

    // Method to add a new menu item
    public void addMenuItem(String name, String category, double price) {
        try (Connection conn = Database.connect()) {
            String query = "INSERT INTO MenuItems (name, category, price) VALUES (?, ?, ?)";
            var pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, category);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();

            System.out.println("Added menu item: " + name);

            // Notify all observers that the menu has been updated
            notifyObservers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
