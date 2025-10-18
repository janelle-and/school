import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {

        List<String> planets = new ArrayList<String>();

        System.out.println(planets);

        // Add element
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
//        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Uranus");
        planets.add("Neptune");
        planets.add("Pluto");

        planets.add(4,"Another Planet");

        System.out.println(planets);

        //Access

        System.out.println(planets.get(3));


        //Change / Set

        planets.set(4,"Jupiter");
        System.out.println(planets);

        // Remove
        planets.remove(8);
        System.out.println(planets);

        // if multiple items of same name only first is deleted
        planets.remove("Venus");
        System.out.println(planets);

        // if item removed by name does not exist, no error
        planets.remove("Venus");
        System.out.println(planets);

//        planets.remove(8);
//        System.out.println(planets);

        //Size
        System.out.println("The size is: " + planets.size());

    }
}
