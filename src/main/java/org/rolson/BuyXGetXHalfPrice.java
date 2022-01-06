package org.rolson;

import java.math.BigDecimal;

public class BuyXGetXHalfPrice implements Promo {
    private long buyAmount;
    private long halfPriceAmount;

    public BuyXGetXHalfPrice(long buyAmount, long halfPriceAmount) {
        if(buyAmount <= 0 || halfPriceAmount <= 0) {
            throw new IllegalArgumentException("Buy Amount and Free Amount must be zero or greater");
        }

        this.buyAmount = buyAmount;
        this.halfPriceAmount = halfPriceAmount;
    }

    @Override
    public BigDecimal discount(Item item, long quantity) {
        long amount = quantity / buyAmount;
        long halfPrice = amount * halfPriceAmount;

        return item.getPrice()
                .multiply(BigDecimal.valueOf(halfPrice))
                .divide(BigDecimal.valueOf(2));
    }
}
