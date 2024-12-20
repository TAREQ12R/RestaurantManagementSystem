package views;

import commands.Command;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import commands.MarkAsPaidCommand;
import invoker.ActionInvoker;
import models.Order;
import utils.PaymentDAO;

public class ProcessPayments {
    public static void display() {
        Stage stage = new Stage();
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px;");

        // ListView to display unpaid orders
        ListView<Order> unpaidOrdersList = new ListView<>();
        unpaidOrdersList.getItems().addAll(PaymentDAO.getUnpaidOrders());

        // Button to mark an order as paid
        Button markPaidButton = new Button("Mark as Paid");
        markPaidButton.setOnAction(e -> {
            Order selectedOrder = unpaidOrdersList.getSelectionModel().getSelectedItem();
            if (selectedOrder != null) {
                // Create a command object to mark the order as paid
                Command markPaidCommand = new MarkAsPaidCommand(selectedOrder);
                ActionInvoker invoker = new ActionInvoker();
                invoker.setCommand(markPaidCommand);
                invoker.invoke();  // Execute the mark paid command
                unpaidOrdersList.getItems().remove(selectedOrder);
                System.out.println("Order marked as paid: " + selectedOrder.getDetails());
            }
        });

        root.getChildren().addAll(unpaidOrdersList, markPaidButton);
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Process Payments");
        stage.setScene(scene);
        stage.show();
    }
}
