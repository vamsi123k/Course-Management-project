<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom styles */
        body {
            background-image: url('image10.jpg');
            background-size: cover;
            background-position: center;
        }

        .container {
            float: right; /* Align containers to the right */
            margin-top: 50px; /* Adjust top margin */
            margin-right: 20px; /* Add some space between containers */
        }

        .login-container, .registration-form {
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 8px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
            padding: 30px;
            max-width: 400px;
            margin-left: 700px;
        }



        /* Other styles remain unchanged */
    </style>
</head>
<body>
    <div class="container">
        <div class="login-container">
            <h2>Login</h2>
            <form id="loginForm" method="post" action="login">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Login</button>
            </form>
            <div class="register-link">
                <p>If you don't have an account, <a href="#" id="showRegistration">register here</a>.</p>
            </div>
        </div>

        <div class="registration-form">
            <h2>User Registration</h2>
            <form id="registrationForm" method="post" action="register">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="name">Full Name:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="mobile">Mobile Number:</label>
                    <input type="text" class="form-control" id="mobile" name="mobile" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Register</button>
                <p class="error-message text-danger"></p>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function() {
            // Initially hide the registration form
            $(".registration-form").hide();

            // Show registration form when register link is clicked
            $("#showRegistration").click(function(event) {
                event.preventDefault();
                $(".login-container").hide();
                $(".registration-form").show();
            });

            // Handle form submission for registration
            $("#registrationForm").submit(function(event) {
                event.preventDefault(); // Prevent default form submission

                // Perform AJAX request to register user
                $.ajax({
                    type: "POST",
                    url: "register",
                    data: $(this).serialize(), // Serialize form data
                    success: function(response) {
                        // Registration successful, show login container and hide registration form
                        $(".login-container").show();
                        $(".registration-form").hide();
                    },
                    error: function(xhr, status, error) {
                        // Registration failed, show registration form with error message
                        $(".login-container").hide();
                        $(".registration-form").show();
                        $(".registration-form .error-message").html("Registration failed. Please try again.");
                    }
                });
            });
        });
    </script>
</body>
</html>
