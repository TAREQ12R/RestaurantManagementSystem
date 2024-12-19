package commands;

import models.Order;
import utils.PaymentDAO;

public class MarkAsPaidCommand implements Command {
    private Order order;

    public MarkAsPaidCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        PaymentDAO.markAsPaid(order.getId());
        System.out.println("Order " + order.getId() + " marked as paid.");
    }
}
