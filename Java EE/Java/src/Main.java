public class Main {
    public static void main(String[] args) {

        Repository<Student> studRepo = new Repository<>();
        studRepo.save(new Student(101L,"Alice"));
        studRepo.save(new Student(102L,"Bob"));
        studRepo.save(new Student(103L,"Carl"));

        Repository<Course>  courseRepo = new Repository<>();
        courseRepo.save(new Course(1,"Python"));
        courseRepo.save(new Course(2,"Java"));

        System.out.println(studRepo.findById(101L));
        System.out.println(courseRepo.findById(2));



    }
}