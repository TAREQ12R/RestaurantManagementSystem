package utils;

import models.MenuItem;

public class MenuItemFactory {
    public static MenuItem createMenuItem(String category, String name, double price) {
        return new MenuItem(name, category, price);
    }
}
