package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.controller.LoginServlet.databaseConnection;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");




        int  rowsAffected = databaseConnection.RegisterStudent(username, name, email, mobile, password);



        if (rowsAffected > 0) {
            // Registration successful, redirect to login page
            response.sendRedirect("index.jsp");
        } else {
            // Registration failed, display error message
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Registration failed. Please try again.');");
            out.println("window.location.href='register.jsp';");
            out.println("</script>");
        }


    }
}


