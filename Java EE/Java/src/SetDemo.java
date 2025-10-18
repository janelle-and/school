import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {

        //hash set
        Set<String> guests = new HashSet<>();

        guests.add("Alice");
        guests.add("Bob");
        guests.add("Alice");

        System.out.println(guests);

        //tree set
        Set<Integer> lotteryNumbers = new TreeSet<>();

        lotteryNumbers.add(42);
        lotteryNumbers.add(3);
        lotteryNumbers.add(1);
        lotteryNumbers.add(50);
        lotteryNumbers.add(50);

        System.out.println(lotteryNumbers);

        //linked hash set

        Set<String> countries = new LinkedHashSet<>();

        countries.add("Canada");
        countries.add("France");
        countries.add("Germany");

        //maintains insertion order
        System.out.println(countries);
    }
}
