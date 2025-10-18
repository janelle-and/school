package com.example.studentapi.student_crud_api.model;

public class Student {
    private int id;
    private String name;
    private String program;
    private double gpa;

    public Student(int id, String name, String program, double gpa) {
        this.id = id;
        this.name = name;
        this.program = program;
        this.gpa = gpa;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public double getGpa() {
        return gpa;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", program='" + program + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
