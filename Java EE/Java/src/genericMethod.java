public class genericMethod {
    // use T instead of data type
    public static <T> void printData(T[] values) {
        for (T value : values) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};

        Integer[] numbers = {1, 2, 3, 4};

        printData(names);
        printData(numbers);
    }
}
