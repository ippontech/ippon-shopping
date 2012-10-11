package fr.ippon.examples.shopping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The user's shopping cart.
 */
public class ShoppingCart {

    private Collection<Item> list = new ArrayList<Item>();

    public void addItem(Item item) {
        list.add(item);
    }

    public String printCart() {
        String result = "";
        for (Item item : list) {
            result += item.getName() + "\n";
        }
        return result;
    }

    public BigDecimal getGrossPrice() {
        return BigDecimal.ZERO;
    }

    public BigDecimal calculateVAT() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getNetPrice() {
        return BigDecimal.ZERO;
    }
}
