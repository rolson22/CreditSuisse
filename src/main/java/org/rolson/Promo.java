package org.rolson;

import java.math.BigDecimal;

interface Promo {
    BigDecimal discount(Item item, long quantity);
}
