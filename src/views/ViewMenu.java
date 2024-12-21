package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.MenuItem;
import utils.MenuDAO;
import utils.MenuObserver;

public class ViewMenu implements MenuObserver {
    private TableView<MenuItem> table;  // Class-level TableView
    private MenuDAO menuDAO;

    // Constructor to subscribe ViewMenu to MenuDAO updates
    public ViewMenu(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
        this.menuDAO.addObserver(this);  // Subscribe as observer
    }

    public void display() {
        Stage stage = new Stage();
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px;");

        // Initialize the TableView
        table = new TableView<>();
        setupTableColumns();

        // Load initial data into the table
        ObservableList<MenuItem> menuItems = FXCollections.observableArrayList(menuDAO.getMenuItems());
        table.setItems(menuItems);

        root.getChildren().add(table);

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    // Setup TableView columns
    private void setupTableColumns() {
        TableColumn<MenuItem, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MenuItem, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<MenuItem, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(nameColumn, categoryColumn, priceColumn);
    }

    @Override
    public void update() {
        System.out.println("Menu updated. Refreshing view...");

        // Refresh the TableView with updated data
        ObservableList<MenuItem> updatedItems = FXCollections.observableArrayList(menuDAO.getMenuItems());
        table.setItems(updatedItems);
    }
}
