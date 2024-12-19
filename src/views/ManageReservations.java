package views;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class ManageReservations {
    public static void display() {
        Stage stage = new Stage();
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px;");

        TextField tableField = new TextField();
        tableField.setPromptText("Enter Table Type (Regular/VIP/Outdoor)");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter Reservation Name");

        Button reserveButton = new Button("Reserve");
        reserveButton.setOnAction(e -> {
            String tableType = tableField.getText();
            String name = nameField.getText();
            System.out.println("Reservation for " + name + " at " + tableType + " table.");
        });

        root.getChildren().addAll(tableField, nameField, reserveButton);
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Manage Reservations");
        stage.setScene(scene);
        stage.show();
    }
}
