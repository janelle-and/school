package inClassTasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//  ShopSalesAnalysis
public class Stream {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("Headphones", "Electronics", 89.99, 15),
                new Item("Notebook", "Stationery", 4.99, 120),
                new Item("Monitor", "Electronics", 129.99, 10),
                new Item("Water Bottle", "Home", 14.50, 50),
                new Item("Pen", "Stationery", 1.50, 200),
                new Item("Backpack", "Accessories", 55.00, 25),
                new Item("Desk Lamp", "Home", 24.99, 30)
        );
        // Task 1: Find all items priced over $50 → Print them
        System.out.println("Items priced over $50:");

        List<Item> over50 = items.stream()
                .filter(i->i.price>50)
                        .collect(Collectors.toList());
        System.out.println(over50);

        // Task 2: Get names of these expensive items → Produce a list of item names
        System.out.println("\nNames of expensive items:");

        List<String> expensive = over50.stream()
                .map(i->i.name)
                .collect(Collectors.toList());
        System.out.println(expensive);

        // Task 3: Top 3 cheapest items → Get the 3 cheapest items and print them
        System.out.println("\nTop 3 cheapest items:");

        List<Item> cheapest = items.stream()
                .sorted(Comparator.comparingDouble(i->i.price))
                .limit(3)
                        .collect(Collectors.toList());
        System.out.println(cheapest);

        // Task 4: Calculate total revenue of all items → price× quantity
        System.out.println("\nTotal revenue:");

        double totalRevenue = items.stream()
                .mapToDouble(i->i.price*i.quantity)
                        .sum();
        System.out.println(totalRevenue);

        // Task 5: Average price of all items
        System.out.println("\nAverage price of items:");

        double average = items.stream()
                .mapToDouble(i->i.price)
                .average()
                .orElse(0.0);
        System.out.println(average);

    }


}


class Item {
    String name;
    String category;
    double price;
    int quantity;
    public Item(String name, String category, double price, int
            quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f x %d", name,
                category, price, quantity);
    }
}
