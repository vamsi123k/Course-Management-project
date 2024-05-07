package com.persistance;

import java.sql.*;
import java.util.Set;

public class Service {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/course";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    public static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return con;
    }
    public ResultSet getUser(String username, String password){
        ResultSet result = null;
        try {
            Connection connection = getConnection();
            String sql = "SELECT role FROM user WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public ResultSet getEnrolledCourses(String username){
        ResultSet result = null;
        try {
            Connection connection = getConnection();
            String enrolledCoursesQuery = "SELECT * FROM enrolled join course ON enrolled.courseId = course.courseId WHERE username = ?";
            PreparedStatement enrolledCoursesStmt = connection.prepareStatement(enrolledCoursesQuery);
            enrolledCoursesStmt.setString(1, username);
            ResultSet enrolledCoursesRs = enrolledCoursesStmt.executeQuery();
            return enrolledCoursesRs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static ResultSet getCreatedCourses(String username){
        ResultSet result = null;
        try {
            Connection connection = getConnection();
            String CoursesQuery = "SELECT * FROM course WHERE created_by = ?";
            PreparedStatement CoursesStmt = connection.prepareStatement(CoursesQuery);
            CoursesStmt.setString(1, username);
            ResultSet CoursesRs = CoursesStmt.executeQuery();
            return CoursesRs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int RegisterStudent(String username, String name, String email, String mobile, String password){
        int rowsAffected=0;
        try {
            Connection connection = getConnection();
            String sql = "INSERT INTO user (username, name, email, mobile, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, mobile);
            stmt.setString(5, password);
            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }


}
