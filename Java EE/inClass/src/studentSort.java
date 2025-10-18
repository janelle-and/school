public class studentSort implements Comparable<studentSort> {
    String name;
    int age;
    int marks;


    public studentSort(String name, int age, int marks){
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    public int getMarks(){
        return marks;
    }

    @Override
    public int compareTo(studentSort o) {
        return this.marks - o.marks;
    }

    @Override
    public String toString() {
        return "studentSort{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}
