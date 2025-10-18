import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        System.out.println(fruits);

        Iterator<String> iterator = fruits.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ListIterator<String> listIt = fruits.listIterator();
        while(listIt.hasNext()) {
            System.out.println(listIt.next());
            
            if (fruits.contains("Apple")){
                listIt.set("Cherry");
            }

//            String f = listIt.next();
//            if(f.equals("Apple")) {
//                listIt.remove();
//            }
        }
        System.out.println(fruits);

        while(listIt.hasPrevious()){
            System.out.println(listIt.previous());
        }

    }
}
