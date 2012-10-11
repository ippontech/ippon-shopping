package fr.ippon.examples.shopping;

import java.math.BigDecimal;

/**
 * An item that can be bought by a user.
 */
public class Item {

    private String name;

    private BigDecimal price;

    public Item(String name, int priceAsInteger) {
        this.name = name;
        this.price = new BigDecimal(priceAsInteger);
    }

    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal calculateVAT() {
        return BigDecimal.ZERO;
    }
}
