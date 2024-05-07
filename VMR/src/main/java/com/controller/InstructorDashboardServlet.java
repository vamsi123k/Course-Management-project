package com.controller;

import com.persistance.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/instructorDashboard")

public class InstructorDashboardServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Map<String, String>> createdCourses = new ArrayList<>();
        // Establish database connection
        try {
            // Fetch enrolled courses for a specific student
            String Username = request.getParameter("username");; // Replace with actual username
            ResultSet CoursesRs = Service.getCreatedCourses(Username);
            // Process the results and populate the enrolledCourses list
            while (CoursesRs.next()) {
                Map<String, String> course = new HashMap<>();
                course.put("courseName", CoursesRs.getString("course_name"));
                course.put("description", CoursesRs.getString("course_description"));
                createdCourses.add(course);
            }
            // Close the database connection
            CoursesRs.close();
        } catch ( SQLException e) {
            // Handle any errors that may occur during database access
            e.printStackTrace();
        }
        // Set the recent courses and enrolled courses as attributes in the request
        //request.setAttribute("recentCourses", recentCourses);
        request.setAttribute("createdCourses", createdCourses);
//        response.setContentType("text/plain");
//
//        // Get the PrintWriter object
//        PrintWriter out = response.getWriter();
//
//        // Print the enrolled courses
//        for (Map<String, String> course : enrolledCourses) {
//            out.println("Course Name: " + course.get("courseName"));
//            out.println("Description: " + course.get("description"));
//            out.println(); // Add a blank line between courses
//        }
        // Forward the request to the JSP to display the data
        request.getRequestDispatcher("/InstructorDashboard.jsp").forward(request, response);
    }
}

