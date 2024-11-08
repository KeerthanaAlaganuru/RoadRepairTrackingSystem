<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Citizen_Signup.css">
    <title>Citizen Signup</title>
</head>
<body>

<div class="form-container">
    <h2>Citizen Signup</h2>
    <form action="CitizenSignupServlet" method="POST">
        <label for="citizenName">Name:</label>
        <input type="text" id="citizenName" name="citizenName" required>

        <label for="citizenEmail">Email:</label>
        <input type="email" id="citizenEmail" name="citizenEmail" required>

        <label for="citizenPassword">Password:</label>
        <input type="password" id="citizenPassword" name="citizenPassword" required>

        <label for="citizenPhone">Phone:</label>
        <input type="text" id="citizenPhone" name="citizenPhone">

        <label for="citizenAddress">Address:</label>
        <textarea id="citizenAddress" name="citizenAddress"></textarea>

        <button type="submit" class="button">Sign Up</button>
    </form>

    <p class="login-prompt">Already have an account? <a href="Citizen_Login.jsp">Login here</a></p>
</div>

</body>
</html>
