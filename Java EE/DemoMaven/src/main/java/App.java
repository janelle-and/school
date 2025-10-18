import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        User user = new User("Alice", "alice@gmail.com");

        System.out.println(user);

        Gson gson = new Gson();

        String json = gson.toJson(user);
        System.out.println(json);


    }
}
