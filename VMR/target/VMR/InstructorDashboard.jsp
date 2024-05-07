<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instructor Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Add custom styles here */
        .course {
            margin-bottom: 20px;
        }
    </style>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Brand</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Mycourses</a>
                </li>
                 <li class="nav-item">
                     <a class="nav-link" href="#">Add Course</a>
                 </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="images/image.jpg" alt="Instructor Picture" width="30" height="30"
                            class="rounded-circle">
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Instructor Details</a>
                        <a class="dropdown-item" href="#">Subscription Details</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <h1>Welcome to Instructor Dashboard</h1>
        <h2>Recently Accessed Courses</h2>
        <div class="row" id="recent-courses">
            <!-- Recently accessed courses will be dynamically added here -->
            <%-- Use JSTL or JSP expression language to display dynamic data --%>
            <c:forEach var="course" items="${recentCourses}">
                <div class="col-md-6">
                    <div class="card course">
                        <div class="card-body">
                            <h5 class="card-title">${course.courseName}</h5>
                            <p class="card-text">${course.description}</p>
                            <a href="#" class="btn btn-primary">View Course</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <h2>Courses Created by You</h2>
        <div class="row" id="created-courses">
            <!-- Courses created by the instructor will be dynamically added here -->
            <c:forEach var="course" items="${createdCourses}">
                <div class="col-md-6">
                    <div class="card course">
                        <div class="card-body">
                            <h5 class="card-title">${course.courseName}</h5>
                            <p class="card-text">${course.description}</p>
                            <a href="#" class="btn btn-primary">View Course</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
