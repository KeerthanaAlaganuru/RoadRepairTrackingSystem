<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Supervisor</title>
    <style>
        /* Global reset */
        body, h2, label, input {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        /* Body styling */
        body {
            background-color: #f4f4f4;
            padding: 20px;
            font-size: 16px;
            color: #333;
        }

        /* Form container */
        .form-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 0 auto;
        }

        h2 {
            text-align: center;
            color: #4CAF50;
            margin-bottom: 20px;
        }

        /* Label styling */
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        /* Input styling */
        input[type="text"], input[type="email"], input[type="password"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 12px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Responsive design */
        @media (max-width: 600px) {
            .form-container {
                padding: 20px;
            }
            h2 {
                font-size: 18px;
            }
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add a New Supervisor</h2>
        <form action="AddSupervisorServlet" method="post">
            <!-- Supervisor ID -->
            <label for="id">Supervisor ID:</label>
            <input type="number" id="id" name="supervisor_id" required><br>
            
            <!-- Supervisor Name -->
            <label for="name">Name:</label>
            <input type="text" id="name" name="supervisor_name" required><br>
            
            <!-- Supervisor Email -->
            <label for="email">Email:</label>
            <input type="email" id="email" name="supervisor_email" required><br>
            
            <!-- Supervisor Password -->
            <label for="password">Password:</label>
            <input type="password" id="password" name="supervisor_password" required><br>
            
            <!-- Supervisor Phone -->
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="supervisor_phone"><br>
            
            <input type="submit" value="Add Supervisor">
        </form>
    </div>
</body>
</html>
