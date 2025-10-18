import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortDemo {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(9);
        num.add(2);

        System.out.println(num);
        Collections.sort(num);
        System.out.println(num);

        List<String> names = new ArrayList<>();
        names.add("Zen");
        names.add("Alice");
        names.add("Bob");
        System.out.println(names);
        Collections.sort(names);
        System.out.println(names);

        List<studentSort> students = new ArrayList<>();
        students.add(new studentSort("Bob",20,78));
        students.add(new studentSort("Alice",35,60));
        students.add(new studentSort("Zen",19,90));
        students.add(new studentSort("Bob",20,78));

        // print students
        for (studentSort s : students) {
            System.out.println(s);
        }
        //print sorted students
        Collections.sort(students);
        for (studentSort s : students) {
            System.out.println(s);
        }

        // sorting by name
        System.out.println("sorting by name:");
        students.sort(Comparator.comparing(studentSort::getName));  // :: accessing the "getName" method from "studentSort"
        students.forEach(System.out::println);

        // sorting by age
        System.out.println("sorting by age:");
        students.sort(Comparator.comparing(studentSort::getAge));
        students.forEach(System.out::println);

        // sorting by marks
        System.out.println("sorting by marks:");
        students.sort(Comparator.comparing(studentSort::getMarks));
        students.forEach(System.out::println);


        // sorting by marks (descending order)
        System.out.println("\nSorting marks by descending order and then age");
        students.sort(Comparator.comparing(studentSort::getMarks).reversed()
                .thenComparing(studentSort::getAge));  // can be in same line
        students.forEach(System.out::println);


    }
}
