<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Admin Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            width: 80%;
            max-width: 400px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            font-weight: bold;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group input[type="submit"] {
            background-color: #28a745;
            color: white;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Update Admin Details</h2>

        <form action="UpdateAdminServlet" method="post">
            <!-- Hidden field for admin ID -->
            <input type="hidden" name="adminId" value="${adminId}">

            <div class="form-group">
                <label for="adminName">Admin Name</label>
                <input type="text" id="adminName" name="adminName" value="${adminName}" required>
            </div>

            <div class="form-group">
                <label for="adminEmail">Admin Email</label>
                <input type="email" id="adminEmail" name="adminEmail" value="${adminEmail}" required>
            </div>

            <div class="form-group">
                <label for="adminPhone">Admin Phone</label>
                <input type="text" id="adminPhone" name="adminPhone" value="${adminPhone}" required>
            </div>

            <div class="form-group">
                <label for="adminPassword">New Password</label>
                <input type="password" id="adminPassword" name="adminPassword" placeholder="Enter new password" required>
            </div>

            <div class="form-group">
                <input type="submit" value="Update Details">
            </div>
        </form>
    </div>

</body>
</html>
