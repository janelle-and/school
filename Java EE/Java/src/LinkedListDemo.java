import java.util.List;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        List<String> fruits = new LinkedList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println(fruits);

        fruits.addFirst("Grapes");
        System.out.println(fruits);

        fruits.addLast("Pear");
        System.out.println(fruits);

        //get

        System.out.println(fruits.get(2));
        System.out.println(fruits.getFirst());
        System.out.println(fruits.getLast());

        // set

        fruits.set(4,"Pineapple");
        System.out.println(fruits);

        //remove

        fruits.remove("Pineapple");
        System.out.println(fruits);
        fruits.remove(3);
        System.out.println(fruits);
        fruits.removeFirst();
        System.out.println(fruits);
        fruits.removeLast();
        System.out.println(fruits);

        // contains

        System.out.println("Contains Banana: "+fruits.contains("Banana"));
        System.out.println("Contains Apple: "+fruits.contains("Apple"));

        fruits.add("Banana");
        fruits.add("Orange");


        for(int i=0; i<fruits.size(); i++){
            System.out.println(fruits.get(i));
        }
        //for each
        for(String fruit: fruits){
            System.out.println(fruit);
        }

    }
}
