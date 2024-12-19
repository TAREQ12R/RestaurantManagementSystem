package models;

public class Order {
    private int id; // New field
    private String table;
    private String details;

    // Constructor for fetching existing orders from the database
    public Order(int id, String table, String details) {
        this.id = id;
        this.table = table;
        this.details = details;
    }

    // Constructor for new orders (ID is auto-generated)
    public Order(String table, String details) {
        this.table = table;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getTable() {
        return table;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Table: " + table + ", Details: " + details;
    }
}
