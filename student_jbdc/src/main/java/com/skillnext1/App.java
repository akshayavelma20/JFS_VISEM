// src/main/java/com/skillnext1/App.java
package com.skillnext1;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            StudentDAO dao = new StudentDAO();

            // 1. INSERT
            Student s = new Student("John", 3, "CSE");
            dao.addStudent(s);
            System.out.println("1. Inserted -> ID: " + s.getId() + ", " + s.getName() + ", sem=" + s.getSem() + ", dept=" + s.getDept());

            // 2. UPDATE (change name and sem as example)
            s.setName("John Updated");
            s.setSem(4);
            boolean updated = dao.updateStudent(s);
            System.out.println("2. Update -> ID: " + s.getId() + " updated? " + updated);

            // 3. SELECT ALL (show current table)
            System.out.println("3. All Students:");
            List<Student> all = dao.getAllStudents();
            for (Student st : all) {
                System.out.println("   " + st);
            }

            // 4. (optional) Delete example - uncomment if you want to test delete
            // boolean deleted = dao.deleteStudent(s.getId());
            // System.out.println("4. Delete -> ID: " + s.getId() + " deleted? " + deleted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
