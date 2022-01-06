package org.rolson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BuyXGetXFreeTests {

    @Test
    public void testDiscountWithAQuantityOfZero() {
        Item item = new Item("Ice Cream", BigDecimal.valueOf(2));
        BuyXGetXFree buyXGetXFree = new BuyXGetXFree(2, 1);

        BigDecimal freeAmount = buyXGetXFree.discount(item, 0);
        Assertions.assertEquals(BigDecimal.ZERO, freeAmount);
    }

    @Test
    public void testDiscountWithAQuantityOfFive() {
        Item item = new Item("Ice Cream", BigDecimal.valueOf(2));
        BuyXGetXFree buyXGetXFree = new BuyXGetXFree(2, 1);

        BigDecimal freeAmount = buyXGetXFree.discount(item, 5);
        Assertions.assertEquals(BigDecimal.valueOf(4), freeAmount);
    }

    @Test()
    public void testCreatingPromoWithInvalidArugments() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BuyXGetXFree buyXGetXFree = new BuyXGetXFree(-1, -1);
        });
    }
}
