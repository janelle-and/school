import java.util.ArrayList;
import java.util.List;

public class Generics {
    // task 1 1.
    public static void printList(List<?> list){
        for(Object object : list) {
            System.out.println(object);
        }
    }
    // task 1 2.
    public static double calculateSum(List<? extends Number> numberList){
        double sum = 0.0;
        for(Number num : numberList){
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        list2.add("c");

        printList(list1);
        printList(list2);

        System.out.println(calculateSum(list1));

        List<Double> list3 = new ArrayList<>();
        list3.add(1.5);
        list3.add(2.77);
        list3.add(3.0);

        System.out.println(calculateSum(list3));
    }
}
