package nl.hu.demojersey2.model;

public class Order {
    private int id;
    private String customerName;

    Order( int id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getId() {
        return id;
    }
}