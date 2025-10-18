package Streams;

import java.util.List;

public class Order {
    String name;
    List<Item> items;

    public Order(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }
}
