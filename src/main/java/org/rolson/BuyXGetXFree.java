package org.rolson;

import java.math.BigDecimal;

public class BuyXGetXFree implements Promo {
    private long buyAmount;
    private long freeAmount;

    public BuyXGetXFree(long buyAmount, long freeAmount) {
        if(buyAmount <= 0 || freeAmount <= 0) {
            throw new IllegalArgumentException("Buy Amount and Free Amount must be zero or greater");
        }

        this.buyAmount = buyAmount;
        this.freeAmount = freeAmount;
    }

    @Override
    public BigDecimal discount(Item item, long quantity) {
        long multipliesOfBuyAmount = quantity / buyAmount;
        long freeTotal = multipliesOfBuyAmount * freeAmount;
        return item.getPrice().multiply(BigDecimal.valueOf(freeTotal));
    }

    @Override
    public String toString() {
        return "BuyXGetXFree{" +
                ", buyAmount=" + buyAmount +
                ", freeAmount=" + freeAmount +
                '}';
    }
}
