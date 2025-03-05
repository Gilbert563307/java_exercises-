package nl.hu.demojersey2.model;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;


public class Company {
    private int id;
    private String name;
    private List<Order> orders;

    Company(int id, String name, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.orders = orders;
    }

    static public Company getCompany() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Mirko"));
        orders.add(new Order(2, "Jos"));
        orders.add(new Order(3, "Pim"));
        return new Company(1, "MyCompany", orders);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderById(int id){
        for (Order order : orders) {
            if (order.getId() == id){
                return order;
            }
        }
        return null;
    }
}