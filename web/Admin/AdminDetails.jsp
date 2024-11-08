<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="AdminDetails.css">
    <title>Admin Details</title>
   
</head>
<body>

    <div class="container">
        <h2>Admin Details</h2>
        
        <table>
            <tr>
                <th>Admin ID</th>
                <td><%= request.getAttribute("adminId") %></td>
            </tr>
            <tr>
                <th>Admin Name</th>
                <td><%= request.getAttribute("adminName") %></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><%= request.getAttribute("adminEmail") %></td>
            </tr>
            <tr>
                <th>Phone</th>
                <td><%= request.getAttribute("adminPhone") %></td>
            </tr>
        </table>

        <div style="text-align: center;">
            <a href="AdminPage.jsp" class="button">Back to Home</a>
            <a href="updateAdminDetails.jsp" class="button">Update Details</a>
        </div>
    </div>

</body>
</html>
