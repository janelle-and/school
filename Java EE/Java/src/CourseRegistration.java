import java.util.*;

public class CourseRegistration {
    public static void main(String[] args) {
        //in class practise for lists/sets/map

        List<String> courses = new ArrayList<>();

        // user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter courses names: ");

        while(true){
            String course = sc.nextLine();
            if(course.equalsIgnoreCase("done")){
                break;
            }
            courses.add(course);
        }

        System.out.println(courses);

        Set<String> uniqueCourses = new HashSet<>(courses);
        System.out.println(uniqueCourses);


        Map<String,String> courseProfessor = new HashMap<>();
        for (String course: uniqueCourses){
            System.out.println("Enter instructor for " + course + ": ");
            String prof = sc.nextLine();
            courseProfessor.put(course, prof);
        }

        System.out.println("Final course registration:");
        for( Map.Entry<String, String> entry : courseProfessor.entrySet()){
            System.out.println("Course: " + entry.getKey() + " | Professor: " + entry.getValue());
        }
    }

}
