package fr.ippon.examples.shopping;

public class ItemFactory {

    private static ItemFactory itemFactory = new ItemFactory();

    public static ItemFactory getInstance() {
        return itemFactory;
    }

    public Item createItem(String name, int price, String type) {
        return createItem(name, price);
    }

    public Item createItem(String name, int price) {
        return new Item(name, price);
    }
}
