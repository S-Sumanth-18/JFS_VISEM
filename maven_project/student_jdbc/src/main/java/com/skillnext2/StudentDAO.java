package com.skillnext2;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext2_db";
    private static final String USER = "root";
    private static final String PASSWORD = "sumanth@123"; // change if needed

    // Add student
    public void addStudent(Student s) throws Exception {
        String sql = "INSERT INTO students1 (name, sem, dept) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, s.getName());
            stmt.setInt(2, s.getSem());
            stmt.setString(3, s.getDept());

            stmt.executeUpdate();
        }
    }

    // Fetch all students
    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students1";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setSem(rs.getInt("sem"));
                s.setDept(rs.getString("dept"));
                list.add(s);
            }
        }
        return list;
    }

    // Update student
    public void updateStudent(Student s) throws Exception {
        String sql = "UPDATE students1 SET name=?, sem=?, dept=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, s.getName());
            stmt.setInt(2, s.getSem());
            stmt.setString(3, s.getDept());
            stmt.setInt(4, s.getId());

            stmt.executeUpdate();
        }
    }

    // Delete student
    public void deleteStudent(int id) throws Exception {
        String sql = "DELETE FROM students1 WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
