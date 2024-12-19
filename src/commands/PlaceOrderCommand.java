package commands;

import models.Order;
import controllers.OrderManager;

public class PlaceOrderCommand implements Command {
    private String tableNumber;
    private String itemDetails;

    public PlaceOrderCommand(String tableNumber, String itemDetails) {
        this.tableNumber = tableNumber;
        this.itemDetails = itemDetails;
    }

    @Override
    public void execute() {
        OrderManager orderManager = OrderManager.getInstance();
        Order order = new Order(tableNumber, itemDetails);
        orderManager.saveOrder(order);
        System.out.println("Order placed for table " + tableNumber + ": " + itemDetails);
    }
}
