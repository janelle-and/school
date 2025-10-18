import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    // Array of products to be added by the user
    List<Product> products = new ArrayList<>();

    // Main method that starts the program and calls the menu() method
    public static void main(String[] args){
        Main main = new Main();
        main.menu();
    }

    // menu method that prompts the user for input and calls the appropriate function
    public void menu(){
        // menu options prompting the user
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Choose an option:
                1. Add Product
                2. Remove Product
                3. View All Products
                4. Update Product Details
                5. Filter Products by Price Range
                6. Sort Products by Price
                7. Show Total Inventory Value
                8. Exit""");

        String option = input.nextLine();

        // switch case depending on the user's input
        switch (option) {
            // adding a new product using the user inputted name, quantity and price
            // calls the addProduct(name,quantity,price) method
            case "1":
                try {
                    // prompts user
                    Scanner option1 = new Scanner(System.in);
                    System.out.println("Enter product name:");
                    String name = option1.nextLine();
                    System.out.println("Enter product quantity:");
                    int quantity = option1.nextInt();
                    System.out.println("Enter product price:");
                    double price = option1.nextDouble();
                    // calls addProduct method that add the new product
                    addProduct(name, quantity, price);
                }
                // handles invalid user input
                catch(Exception e){
                    System.out.println("Invalid input");
                }
                menu();
                break;
            // removes a product based on the name inputted by the user, calls the removeName(name) method
            case "2":
                // prompts user for the name of the product to be removed
                Scanner option2 = new Scanner(System.in);
                System.out.println("Enter name of product to be removed:");
                String removeName = option2.nextLine();

                // calls removeProduct method that remove the chosen product
                removeProduct(removeName);
                menu();
                break;
            // displays all products in the list on the screen, calls the viewAllProducts() method
            case "3":
                System.out.println("All products:");
                viewAllProducts();
                Scanner option3 = new Scanner(System.in);
                // waits for user input to continue to main menu
                System.out.println("Press enter to continue...");
                option3.nextLine();
                menu();
                break;
            // update a product's price and quantity by name, depending on user input, calls the updateProduct(name,quantity,price) method
            case "4":
                try {
                    // gets user input to update the product
                    Scanner option4 = new Scanner(System.in);
                    System.out.println("Enter name of product to be updated:");
                    String updateName = option4.nextLine();
                    System.out.println("Enter updated quantity:");
                    int updateQuantity = option4.nextInt();
                    System.out.println("Enter updated price:");
                    double updatePrice = option4.nextDouble();

                    // calls updateProduct method to update the chosen product
                    updateProduct(updateName, updateQuantity, updatePrice);
                }
                // handles invalid user input
                catch(Exception e){
                    System.out.println("Invalid input");
                }
                menu();
                break;
            // filtering products by range, min and max inputted by the user, calls the filterProduct(min,max) method
            case "5":
                try {
                    // gets min and max for the range from the user
                    Scanner option5 = new Scanner(System.in);
                    System.out.println("Enter min of the range:");
                    int min = option5.nextInt();
                    System.out.println("Enter max of the range:");
                    int max = option5.nextInt();

                    // calls the filterProduct method that filters the product according the user's input
                    filterProduct(min, max);
                }
                // handles invalid user input
                catch (Exception e){
                    System.out.println("Invalid input");
                }
                menu();
                break;
            // sorts products in ascending or descending order based on user input, call the sortBy(sortBy) method
            case "6":
                try {
                    // gets user input on if the products should be sorted in ascending or descending order
                    Scanner option6 = new Scanner(System.in);
                    System.out.println("""
                            Sort by:
                            1. Ascending
                            2. Descending""");
                    int sortBy = option6.nextInt();
                    // calls sortBy method that sorts and displays the sorted list
                    sortBy(sortBy);
                }
                // handles invalid user input
                catch(Exception e){
                    System.out.println("Invalid input.");
                }
                menu();
                break;
            // display the total inventory value of products in the list, call the totalInventory() method
            case "7":
                Scanner option7 = new Scanner(System.in);
                totalInventory();
                // waits for user input to return to main menu
                System.out.println("Press enter to continue...");
                option7.nextLine();
                menu();
                break;
            // stops the program
            case "8":
                break;
            // handles invalid input, prompting the user with the menu options again
            default:
                System.out.println("Invalid input.");
                menu();
        }
    }

    // method that takes the name, quantity and price from user and creates a new object Product to the list products
    public void addProduct(String name, int quantity, double price) {
        products.add(new Product(name,quantity,price));
    }

    // removes any product with the name given by the user from the products list
    public void removeProduct(String name){
        products.removeIf(p -> p.getName().equals(name));
    }

    // displays all products in the list on the screen
    public void viewAllProducts(){
        for(Product p : products){
            System.out.println(p);
        }
    }

    // Updates any product's quantity and price, depending on the name given by the user.
    public void updateProduct(String name, int quantity, double price){
        for (Product p : products){
            if (p.getName().equals(name)){
                p.setQuantity(quantity);
                p.setPrice(price);
            }
        }
    }

    // filters the products given the range by the user, displays the appropriate products on the screen, then waits for user input to return to main menu
    public void filterProduct(double min, double max){
        List<Product> range = products.stream()
                .filter(p -> p.price>=min && p.price<=max)
                .collect(Collectors.toList());
        System.out.println(range);
        Scanner wait = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        wait.nextLine();
    }

    // sorts all products from the list in ascending or descending order depending on the user input
    public void sortBy(int sortBy){
        List<Product> sorted;
        if(sortBy==1){
            sorted = products.stream()
                    .sorted(Comparator.comparingDouble(p -> p.price))
                    .collect(Collectors.toList());
        }
        else{
            sorted = products.stream()
                    .sorted(Comparator.comparingDouble(p -> p.price))
                    .collect(Collectors.toList())
                    .reversed();
        }
        System.out.println(sorted);
        // waits for user input to continue to main menu
        Scanner wait = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        wait.nextLine();
    }

    // calculates and displays the total inventory value of all products
    public void totalInventory(){
        double totalValue = products.stream()
                .mapToDouble(p -> p.price * p.quantity)
                .sum();
        System.out.println("Total Inventory Value: " + totalValue);
    }
}


class Product {
    String name;
    int quantity;
    double price;

    // constructor method
    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // getter methods
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // toString method
    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", quantity=" + quantity + ", price=" + price + '}';
    }
}
