package com.skillnext1;

public class Student {

    private int id;
    private String name;
    private int sem;
    private String dept;

    public Student() {}

    public Student(int id, String name, int sem, String dept) { // parameterized constructor
        this.id = id;
        this.name = name;
        this.sem = sem;
        this.dept = dept;
    }

    public Student(String name, int sem, String dept) {
        this.name = name;
        this.sem = sem;
        this.dept = dept;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getSem() { return sem; }
    public String getDept() { return dept; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSem(int sem) { this.sem = sem; }
    public void setDept(String dept) { this.dept = dept; }

    @Override
    public String toString() {
        return "Student{ id=" + id + ", name='" + name +
                "', sem=" + sem + ", dept='" + dept + "' }";
    }
}
