package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import models.MenuItem;
import utils.MenuDAO;

public class ViewMenu {
    public static void display() {
        Stage stage = new Stage();
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px;");

        // TableView for Menu Items
        TableView<MenuItem> table = new TableView<>();

        // Columns
        TableColumn<MenuItem, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MenuItem, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<MenuItem, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(nameColumn, categoryColumn, priceColumn);

        // Add data to TableView
        ObservableList<MenuItem> menuItems = FXCollections.observableArrayList(MenuDAO.getMenuItems());
        System.out.println("Number of menu items retrieved: " + menuItems.size());
        table.setItems(menuItems);

        root.getChildren().add(table);
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
}
