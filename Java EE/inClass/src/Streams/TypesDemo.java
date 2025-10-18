package Streams;

import java.util.Arrays;
import java.util.List;

public class TypesDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // sequential vs parallel stream

        System.out.println("Sequential stream:");
        numbers.stream()
                .map(i -> i*i)
                .forEach(System.out::println);

        // faster but doesn't maintain order
        System.out.println("Parallel stream:");
        numbers.parallelStream()
                .map(i -> i*i)
                .forEach(System.out::println);


        // peek

        System.out.println("\nPeek demo");
        numbers.stream()
                .peek(n-> System.out.println("Original: "+ n))
                .filter(i -> i%2==0)
                .peek(n -> System.out.println("Filtered: " + n))
                .map(i -> i*i)
                .forEach(System.out::println);
    }
}
