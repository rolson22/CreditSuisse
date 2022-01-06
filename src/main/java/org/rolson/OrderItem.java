package org.rolson;

import java.math.BigDecimal;

public class OrderItem {
    private final Item item;
    private final long quantity;

    public OrderItem(Item item, long quantity) {
        this.quantity = quantity;
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }

    public BigDecimal getTotal() {
        return this.item.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal promoDiscount() {
        return this.item.getPromoOpt().map(a -> a.discount(item,  quantity)).orElse(BigDecimal.ZERO);
    }

    public BigDecimal getTotalWithPromo() {
        return this.getTotal().subtract(promoDiscount());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
