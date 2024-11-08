<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Clerk</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom styles for smaller width */
        .container {
            max-width: 500px;  /* Set a smaller max-width for the form */
            margin-top: 50px;  /* Add some space at the top */
        }

        .form-label {
            font-weight: bold;
        }

        .btn-danger {
            width: 100%;  /* Make the button stretch across the container */
        }

        h2 {
            text-align: center;  /* Center the heading */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Delete Clerk</h2>

        <form action="DeleteClerkServlet" method="POST">
            <div class="mb-3">
                <label for="clerkId" class="form-label">Clerk ID</label>
                <input type="text" class="form-control" id="clerkId" name="clerkId" required>
            </div>
            <button type="submit" class="btn btn-danger">Delete Clerk</button>
        </form>
    </div>

    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
