package org.rolson;

import java.math.BigDecimal;
import java.util.Optional;

public class Item {
    private final String flavour;
    private Optional<Promo> promoOpt;
    private BigDecimal price;

    public Item(String flavour, BigDecimal price) {
        this(flavour, Optional.empty(), price);
    }

    public Item(String flavour, Optional<Promo> promoOpt, BigDecimal price) {
        this.flavour = flavour;
        this.promoOpt = promoOpt;
        this.price = price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPromoOpt(Optional<Promo> promoOpt) {
        this.promoOpt = promoOpt;
    }

    public String getFlavour() {
        return flavour;
    }

    public Optional<Promo> getPromoOpt() {
        return promoOpt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(flavour, item.flavour)
                .append(promoOpt, item.promoOpt)
                .append(price, item.price)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder
                .HashCodeBuilder(17, 37)
                .append(flavour)
                .append(promoOpt)
                .append(price)
                .toHashCode();
    }


}
