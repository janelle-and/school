package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(new Order("Alice", Arrays.asList(
                        new Item("Laptop", "Electronic", 1200, 1),
                        new Item("Mouse", "Electronic", 25, 2))),
                new Order("Bob", Arrays.asList(
                        new Item("Shirt", "Clothing", 40, 3),
                        new Item("Mouse", "Electronic", 30, 3)
                )),
                new Order("Carl", Arrays.asList(
                        new Item("Book", "Education", 15, 2),
                        new Item("Pen", "Education", 2, 10)
                )));

        // Flatten all items from our orders using flatMap()

        List<Item> allItems = orders.stream()
                .flatMap(o -> o.items.stream())
                .collect(Collectors.toList());
        System.out.println("All items:" + allItems);

        // Find items price > 100
        List<Item> expensive = allItems.stream()
                .filter(o -> o.price > 100)
                .collect(Collectors.toList());
        System.out.println("Expensive:" + expensive);

        // Get the names of all items
        List<String> itemsNames = allItems.stream()
                .map(item -> item.name)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Item names:" + itemsNames);


        // Sort items by price
        List<Item> sortByPrice = allItems.stream()
                .sorted(Comparator.comparingInt(item->item.price))
                .collect(Collectors.toList());
        System.out.println("Sorted by price:" + sortByPrice);

        // Display only the first 3 items
        List<Item> sortByPriceLim = allItems.stream()
                .sorted(Comparator.comparingInt(item->item.price))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Sorted by price first 3:" + sortByPriceLim);

        List<Item> sortByPriceSkip = allItems.stream()
                .sorted(Comparator.comparingInt(item->item.price))
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Sorted by price skip first 2:" + sortByPriceSkip);

        // Display all the categories
        Set<String> categories = allItems.stream()
                .map(item -> item.category)
                .collect(Collectors.toSet());
        System.out.println("Categories:" + categories);

        // Total revenue
        double totalRevenue = allItems.stream()
                .mapToDouble(item->item.price*item.quantity)
                .sum();
        System.out.println("Total revenue: "+totalRevenue);


        // anyMatch
            //noneMatch
            //allMatch

        boolean priceGreater = allItems.stream()
                .noneMatch(i -> i.price==0);
        System.out.println(priceGreater);

        // Average price of items
        double average = allItems.stream()
                .mapToDouble(item->item.price)
                .average().orElse(0.0); // if nothing in list
        System.out.println("Average price: "+average);

        // find first item
        //findFirst()

        Optional<Item> firstItem = allItems.stream().findFirst();
        System.out.println("First item: " + firstItem);

        List<Integer> empty = new ArrayList<>();
        Optional<Integer> first = empty.stream().findFirst();
        System.out.println("First item (empty list): " + first.orElse(0));

        // findAny() - show any item
        Optional<Item> findAny = allItems.stream().findAny();
        System.out.println("Find any: "+ findAny.orElse(null));

        // max priced item
        Optional<Item> maxPrice = allItems.stream()
                .max(Comparator.comparingInt(item->item.price));
        System.out.println("Max price: " + maxPrice.orElse(null));

        // min priced item
        Optional<Item> minPrice = allItems.stream()
                .min(Comparator.comparingInt(item->item.price));
        System.out.println("Min price: " + minPrice.orElse(null));

        // grouping

        // group by category

        Map<String, List<Item>> categoryGroups = allItems.stream()
            .collect(Collectors.groupingBy(item -> item.category));
        System.out.println("Category groups: " + categoryGroups);


    }
}
