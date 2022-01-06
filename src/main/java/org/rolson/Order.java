package org.rolson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> orders;

    public Order(List<OrderItem> orders) {
        this.orders = orders;
    }

    public Order() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(OrderItem order) {
        orders.add(order);
    }

    public List<OrderItem> getOrders() {
        return orders;
    }
}
