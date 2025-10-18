import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        //instead of needing to add each num individually
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        // even numbers
        System.out.println("Print only even numbers");

        nums.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);


        // square the numbers
        System.out.println("\nPrint square of all numbers");

        nums.stream().map(n -> n * n).forEach(System.out::println);


        // square even numbers
        System.out.println("\nPrint square of all even numbers");

        nums.stream().filter(n -> n % 2 == 0).map(n -> n * n).forEach(System.out::println);


        // numbers > 5
        System.out.println("\nPrint numbers greater than 5");

        nums.stream().filter(n -> n > 5).forEach(System.out::println);


        // words
        List<String> words = Arrays.asList("word", "apple", "Sandwich", "snake", "elephant", "Shark");

        // length of the words beginning with s
        System.out.println("\nPrint length of the words that begin with S (case insensitive)");

        words.stream().filter(w -> w.toLowerCase().startsWith("s"))
                .map(word->word.length()).forEach(System.out::println);


        // collect
        System.out.println("\n");
        List<Integer> squares = nums.stream().filter(n->n%2==0).map(n -> n*n).collect(Collectors.toList());

        System.out.println(squares+"\n");


        var stream = nums.stream().filter(n->{
            System.out.println("Filtering "+n);
            return n%2==0;
        }).map(n->{
            System.out.println("Mapping "+n);
            return n*n;
        });

        List<Integer> squares2 = stream.collect(Collectors.toList());
        System.out.println(squares2+"\n");


        Stream<Integer> numsStream = nums.stream();

        List<Integer> evenNumbers = numsStream.filter(n->n%2==0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        // causes error because this stream has already been used(consumed) (fix -> make another stream)
//        long count = numsStream.count();
//        System.out.println(count);

        //making another stream
        Stream<Integer> numsStream2 = nums.stream();
        long count = numsStream2.count();
        System.out.println(count+"\n");



    }
}
