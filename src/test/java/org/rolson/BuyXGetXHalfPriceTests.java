package org.rolson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BuyXGetXHalfPriceTests {
    @Test
    public void testDiscountWithAQuantityOfZero() {
        Item item = new Item("Ice Cream", BigDecimal.valueOf(2));
        BuyXGetXHalfPrice buyXGetXHalfPrice = new BuyXGetXHalfPrice(2, 1);

        BigDecimal freeAmount = buyXGetXHalfPrice.discount(item, 0);
        Assertions.assertEquals(BigDecimal.ZERO, freeAmount);
    }

    @Test
    public void testDiscountWithAQuantityOfFive() {
        Item item = new Item("Ice Cream", BigDecimal.valueOf(2));
        BuyXGetXHalfPrice buyXGetXHalfPrice = new BuyXGetXHalfPrice(2, 1);

        BigDecimal freeAmount = buyXGetXHalfPrice.discount(item, 5);
        Assertions.assertEquals(BigDecimal.valueOf(2), freeAmount);
    }

    @Test
    public void testCreatingPromoWithInvalidArugments() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BuyXGetXHalfPrice buyXGetXHalfPrice = new BuyXGetXHalfPrice(-1, -1);
        });
    }
}
