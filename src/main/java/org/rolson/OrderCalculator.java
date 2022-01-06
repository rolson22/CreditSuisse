package org.rolson;

import java.math.BigDecimal;

public class OrderCalculator {

    private final Order order;

    public OrderCalculator(Order order) {
        this.order = order;
    }

    public BigDecimal getTotalOrder() {
        return order.getOrders().stream().map(OrderItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalPromo() {
        return order.getOrders().stream().map(OrderItem::promoDiscount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalToPay() {
        return getTotalOrder().subtract(getTotalPromo());
    }

}
