package utils;

import models.MenuItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
    public static List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        try (Connection conn = Database.connect()) {
            String query = "SELECT name, category, price FROM MenuItems";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Log each row
                System.out.println("Retrieved: " + rs.getString("name") + ", " + rs.getString("category") + ", " + rs.getDouble("price"));
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
}
