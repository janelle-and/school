// with databse entity interface
public class Student implements DatabaseEntity{
    long id;
    String name;

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public long getId(){
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
