package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.MenuDAO;

public class Main extends Application {
    private MenuDAO menuDAO;

    @Override
    public void start(Stage primaryStage) {
        // Initialize DAO
        menuDAO = new MenuDAO();

        // Root layout
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        // Buttons for navigation
        Button viewMenuButton = new Button("View Menu");
        Button placeOrderButton = new Button("Place Order");
        Button manageReservationsButton = new Button("Manage Reservations");
        Button processPaymentsButton = new Button("Process Payments");
        Button reportOrdersButton = new Button("View Reports");
        Button addMenuItemButton = new Button("Add Menu Item");

        // Set button actions to navigate between screens
        viewMenuButton.setOnAction(e -> {
            System.out.println("Navigating to View Menu...");
            ViewMenu viewMenu = new ViewMenu(menuDAO);  // Pass DAO to ViewMenu
            viewMenu.display();
        });

        placeOrderButton.setOnAction(e -> {
            System.out.println("Navigating to Place Order...");
            PlaceOrder.display();
        });

        manageReservationsButton.setOnAction(e -> {
            System.out.println("Navigating to Manage Reservations...");
            ManageReservations.display();
        });

        processPaymentsButton.setOnAction(e -> {
            System.out.println("Navigating to Process Payments...");
            ProcessPayments.display();
        });

        reportOrdersButton.setOnAction(e -> {
            System.out.println("Navigating to View Reports...");
            ReportOrders.display();
        });
        addMenuItemButton.setOnAction(e -> {
            menuDAO.addMenuItem("Pasta", "Main Course", 11.99);
            System.out.println("Pasta added to menu!");
        });

        // Add buttons to layout
        root.getChildren().addAll(
                viewMenuButton, placeOrderButton,
                manageReservationsButton, processPaymentsButton,
                reportOrdersButton,addMenuItemButton
        );

        // Scene setup
        Scene scene = new Scene(root, 300, 400);
        scene.getStylesheets().add(getClass().getResource("/resources/styles.css").toExternalForm());

        primaryStage.setTitle("Restaurant Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
