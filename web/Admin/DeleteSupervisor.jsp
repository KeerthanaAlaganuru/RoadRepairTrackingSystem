<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Supervisor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Delete Supervisor</h2>

        <form action="DeleteSupervisorServlet" method="POST">
            <div class="mb-3">
                <label for="supervisorId" class="form-label">Supervisor ID</label>
                <input type="text" class="form-control" id="supervisorId" name="supervisorId" required>
            </div>
            <button type="submit" class="btn btn-danger">Delete Supervisor</button>
        </form>
    </div>

    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
