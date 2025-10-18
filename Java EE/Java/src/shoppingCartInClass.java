import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Set;

public class shoppingCartInClass {
    public static void main(String[] args) {
        System.out.println("Task 1");
        // Shopping Cart
        ArrayList<String> cart =  new ArrayList<>();
        cart.add("Laptop");
        cart.add("Mouse");
        cart.add("Laptop");
        cart.add("Keyboard");

        System.out.println(cart);

        // Wish list
        Set<String> wishlist = new LinkedHashSet<>();
        wishlist.add("Laptop");
        wishlist.add("Headphones");
        wishlist.add("Laptop");

        System.out.println(wishlist);

        // Bonus tasks

        cart.add("Smartwatch");
        wishlist.add("Smartwatch");
        wishlist.remove("Headphones");
        System.out.println(cart);
        System.out.println(wishlist);


        // Task 2
        System.out.println("\nTask 2");

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(52);
        list.add(300);
        list.add(45);
        list.add(15);

        ListIterator<Integer> listIt = list.listIterator();
        while(listIt.hasNext()){
            System.out.println(listIt.next());

//            int n = listIt.next();
//            if(n.equals(15)){
//                listIt.set(0);
//            }
        }
        while(listIt.hasPrevious()){
            System.out.println(listIt.previous());
        }


    }
}
