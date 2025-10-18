public class Course implements DatabaseEntity{
    long id;
    String title;

    public Course(long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public long getId(){
        return id;
    }

    @Override
    public String getName() {
        return  title;
    }
}
