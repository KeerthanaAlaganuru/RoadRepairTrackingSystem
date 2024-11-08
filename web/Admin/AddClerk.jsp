<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Clerk</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            padding-top: 50px;
        }
        .container {
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 40px;
            border-radius: 8px;
            width: 500px;
        }
        .btn-custom {
            background-color: #4CAF50;
            color: white;
        }
        .btn-custom:hover {
            background-color: #45a049;
        }
        .form-label {
            font-weight: 600;
        }
        .heading {
            font-size: 30px;
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h3 class="heading">Add Clerk</h3>
        <form action="AddClerkServlet" method="post">
            <div class="mb-3">
                <label for="clerkId" class="form-label">Clerk ID</label>
                <input type="number" class="form-control" id="clerkId" name="clerkId" required>
            </div>
            <div class="mb-3">
                <label for="clerkName" class="form-label">Clerk Name</label>
                <input type="text" class="form-control" id="clerkName" name="clerkName" required>
            </div>
            <div class="mb-3">
                <label for="clerkEmail" class="form-label">Clerk Email</label>
                <input type="email" class="form-control" id="clerkEmail" name="clerkEmail" required>
            </div>
            <div class="mb-3">
                <label for="clerkPassword" class="form-label">Clerk Password</label>
                <input type="password" class="form-control" id="clerkPassword" name="clerkPassword" required>
            </div>
            <div class="mb-3">
                <label for="clerkPhone" class="form-label">Clerk Phone</label>
                <input type="text" class="form-control" id="clerkPhone" name="clerkPhone">
            </div>
            <button type="submit" class="btn btn-custom">Add Clerk</button>
        </form>
    </div>
</body>
</html>
