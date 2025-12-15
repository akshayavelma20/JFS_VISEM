// src/main/java/com/skillnext1/StudentDAO.java
package com.skillnext1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext1_db";
    private static final String USER = "root";
    private static final String PASS = "Akshaya@20"; // keep your real password

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Insert Student (AUTO_INCREMENT) and set generated id on the object
    public void addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO student (name, sem, dept) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getSem());
            ps.setString(3, s.getDept());

            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Insert failed, no rows affected.");

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) s.setId(rs.getInt(1));
            }
        }
    }

    // Update student by id. Returns true if row updated.
    public boolean updateStudent(Student s) throws SQLException {
        String sql = "UPDATE student SET name = ?, sem = ?, dept = ? WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getSem());
            ps.setString(3, s.getDept());
            ps.setInt(4, s.getId());

            int affected = ps.executeUpdate();
            return affected > 0;
        }
    }

    // Delete student by id. Returns true if deleted.
    public boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;
        }
    }

    // Get student by id (null if not found)
    public Student getStudentById(int id) throws SQLException {
        String sql = "SELECT id, name, sem, dept FROM student WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("sem"),
                            rs.getString("dept")
                    );
                } else return null;
            }
        }
    }

    // Fetch all students
    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id, name, sem, dept FROM student ORDER BY id";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("sem"),
                        rs.getString("dept")
                );
                list.add(s);
            }
        }
        return list;
    }
}
