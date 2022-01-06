package org.rolson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

public class OrderItemTests {

    @Test
    public void testCalculateOrderItemWithNoPromo() {
        Item item = new Item("Ice Cream", BigDecimal.valueOf(2));
        OrderItem orderItem = new OrderItem(item, 5);
        BigDecimal discount = orderItem.promoDiscount();
        BigDecimal total = orderItem.getTotal();
        BigDecimal totalWithPromo = orderItem.getTotalWithPromo();

        Assertions.assertEquals(BigDecimal.ZERO, discount);
        Assertions.assertEquals(BigDecimal.valueOf(10), total);
        Assertions.assertEquals(BigDecimal.valueOf(10), totalWithPromo);
    }

    @Test
    public void testCalculateOrderItemWithPromo() {
        BuyXGetXFree buyXGetXFree = new BuyXGetXFree(2,1);
        Item item = new Item("Ice Cream", Optional.of(buyXGetXFree), BigDecimal.valueOf(2));
        OrderItem orderItem = new OrderItem(item, 5);
        BigDecimal discount = orderItem.promoDiscount();
        BigDecimal total = orderItem.getTotal();
        BigDecimal totalWithPromo = orderItem.getTotalWithPromo();

        Assertions.assertEquals(BigDecimal.valueOf(4), discount);
        Assertions.assertEquals(BigDecimal.valueOf(10), total);
        Assertions.assertEquals(BigDecimal.valueOf(6), totalWithPromo);
    }

}
