package views;

import commands.Command;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import commands.PlaceOrderCommand;
import invoker.ActionInvoker;

public class PlaceOrder {
    public static void display() {
        Stage stage = new Stage();
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px;");

        // ListView for Menu Items
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(
                "Pizza - $10.99",
                "Fries - $4.99",
                "Ice Cream - $3.49"
        );

        // Input field for Table ID
        TextField tableField = new TextField();
        tableField.setPromptText("Enter Table Number");

        // Button to submit order
        Button submitButton = new Button("Place Order");
        submitButton.setOnAction(e -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            String tableNumber = tableField.getText();

            // Create a command object to place the order
            if (selectedItem != null && !tableNumber.isEmpty()) {
                Command placeOrderCommand = new PlaceOrderCommand(tableNumber, selectedItem);
                ActionInvoker invoker = new ActionInvoker();
                invoker.setCommand(placeOrderCommand);
                invoker.invoke();  // Execute the place order command
                stage.close();
            } else {
                System.out.println("Please select an item and enter a table number.");
            }
        });

        root.getChildren().addAll(listView, tableField, submitButton);
        Scene scene = new Scene(root, 300, 400);
        stage.setTitle("Place Order");
        stage.setScene(scene);
        stage.show();
    }
}
