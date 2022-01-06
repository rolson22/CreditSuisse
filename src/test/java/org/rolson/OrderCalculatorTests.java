package org.rolson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderCalculatorTests {

    @Test
    public void testWithZeroOrders() {
        List<OrderItem> orderItems = new ArrayList<>();
        Order order = new Order(orderItems);
        OrderCalculator orderCalculator = new OrderCalculator(order);

        Assertions.assertEquals(BigDecimal.ZERO, orderCalculator.getTotalOrder());
        Assertions.assertEquals(BigDecimal.ZERO, orderCalculator.getTotalPromo());
        Assertions.assertEquals(BigDecimal.ZERO, orderCalculator.getTotalToPay());
    }

    @Test
    public void testWithOneOrder() {
        List<OrderItem> orderItems = new ArrayList<>();
        Item item = new Item("Ice Cream", BigDecimal.valueOf(2));
        OrderItem orderItem = new OrderItem(item, 2);
        orderItems.add(orderItem);
        Order order = new Order(orderItems);
        OrderCalculator orderCalculator = new OrderCalculator(order);

        Assertions.assertEquals(BigDecimal.valueOf(4), orderCalculator.getTotalOrder());
        Assertions.assertEquals(BigDecimal.ZERO, orderCalculator.getTotalPromo());
        Assertions.assertEquals(BigDecimal.valueOf(4), orderCalculator.getTotalToPay());
    }

    @Test
    public void testWithMultipleOrders() {
        List<OrderItem> orderItems = new ArrayList<>();
        Item item = new Item("Ice Cream", BigDecimal.valueOf(2));
        BuyXGetXFree buyXGetXFree = new BuyXGetXFree(2, 1);
        Item item2 = new Item("Cake", Optional.of(buyXGetXFree), BigDecimal.valueOf(3));
        OrderItem orderItem2 = new OrderItem(item2, 3);
        OrderItem orderItem = new OrderItem(item, 2);
        orderItems.add(orderItem);
        orderItems.add(orderItem2);
        Order order = new Order(orderItems);
        OrderCalculator orderCalculator = new OrderCalculator(order);

        Assertions.assertEquals(BigDecimal.valueOf(13), orderCalculator.getTotalOrder());
        Assertions.assertEquals(BigDecimal.valueOf(3), orderCalculator.getTotalPromo());
        Assertions.assertEquals(BigDecimal.valueOf(10), orderCalculator.getTotalToPay());
    }
}
