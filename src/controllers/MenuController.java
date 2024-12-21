package controllers;

import utils.MenuDAO;

public class MenuController {
    private MenuDAO menuDAO;

    public MenuController(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    public void addMenuItem(String name, String category, double price) {
        menuDAO.addMenuItem(name, category, price);
    }
}
