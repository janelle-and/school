import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class mapDemo {
    public static void main(String[] args) {
        Map<String,String> grades = new HashMap<>();

        grades.put("Alice","A");
        grades.put("Bob","B");
        grades.put("Charlie","C");
        System.out.println(grades);


        // change element
        grades.put("Alice","A+");
        System.out.println(grades);

        grades.replace("Bob","B","B+");
        System.out.println(grades);

        grades.replace("Bob","B","C+"); //old grade doesn't match so nothing happens
        System.out.println(grades);

        // contains
        System.out.println("Contains Alice" + grades.containsKey("Alice"));
        System.out.println("Contains D grade: " + grades.containsValue("D"));

        // linked hashmap

        Map<String,String> history = new LinkedHashMap<>();

        history.put("Google", "www.google.com");
        history.put("Youtube", "www.youtube.com");
        System.out.println("\n" + history);

        for(Map.Entry<String, String> entry : history.entrySet()){
            System.out.println(entry.getKey() + " - " +  entry.getValue());
        };

        // TreeMap

        TreeMap<String, String> phonebook = new TreeMap<>();

        phonebook.put("Charlie","444-222-1111");
        phonebook.put("Bob","444-222-2222");
        phonebook.put("Alice","444-252-1233");
        System.out.println("\n" + phonebook);

        System.out.println(phonebook.firstEntry());
        System.out.println(phonebook.lastEntry());


    }
}
