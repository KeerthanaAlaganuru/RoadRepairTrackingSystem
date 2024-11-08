<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RRTS - Citizen Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Link to the external CSS file -->
    <link href="Citizen_Login.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="login-container">
        <h2 class="text-center">Hello Citizen, Please Login to Continue</h2>

        <!-- Show error message if present -->
        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
        <div class="alert alert-danger text-center"><%= errorMessage %></div>
        <% } %>

        <form action="CitizenLoginServlet" method="post">
            <div class="mb-3">
                <label for="citizen_email" class="form-label">Email:</label>
                <input type="email" id="citizen_email" name="citizen_email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="citizen_password" class="form-label">Password:</label>
                <input type="password" id="citizen_password" name="citizen_password" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Login</button>
        </form>

        <!-- Back to Home Button -->
        <form action="HomePage.jsp" method="get" class="mt-3">
            <button type="submit" class="btn btn-secondary">Back to Home</button>
        </form>

        <!-- Signup Prompt inside the box -->
        <p class="signup-prompt">Don't have an account? <a href="Citizen_Signup.jsp">Sign up</a></p>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
