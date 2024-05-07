package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.persistance.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    // JDBC URL, username, and password of MySQL server
    static Service databaseConnection = new Service();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate username and password against database
        String role = authenticateUser(username, password);
        if (role != null) {
            // Authentication successful
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("databaseConnection",databaseConnection );

            if (role.equals("student")) {
                //response.sendRedirect("/studentDashboard");
                request.getRequestDispatcher("studentDashboard").forward(request, response);
            } else if (role.equals("instructor")) {
                //response.sendRedirect("instructorDashboard.jsp");
                request.getRequestDispatcher("instructorDashboard").forward(request, response);
            }
        } else {
            // Authentication failed
            response.sendRedirect("index.jsp?error=1");
        }
    }


    private String authenticateUser(String username, String password) {
        try (ResultSet resultSet = databaseConnection.getUser(username, password)) {
            if (resultSet.next()) {
                return resultSet.getString("role"); // Return the role of the user
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if authentication fails
    }

}

