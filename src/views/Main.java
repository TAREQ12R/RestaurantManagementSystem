package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Root layout
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        // Buttons for navigation
        Button viewMenuButton = new Button("View Menu");
        Button placeOrderButton = new Button("Place Order");
        Button manageReservationsButton = new Button("Manage Reservations");
        Button processPaymentsButton = new Button("Process Payments");
        Button reportOrdersButton = new Button("View Reports");




        // TODO: Set button actions to navigate between screens
        viewMenuButton.setOnAction(e -> ViewMenu.display());
        placeOrderButton.setOnAction(e -> PlaceOrder.display());
        manageReservationsButton.setOnAction(e -> ManageReservations.display());
        processPaymentsButton.setOnAction(e -> ProcessPayments.display());
        reportOrdersButton.setOnAction(e -> ReportOrders.display());



        root.getChildren().addAll(viewMenuButton, placeOrderButton, manageReservationsButton, processPaymentsButton);
        root.getChildren().add(reportOrdersButton);
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
