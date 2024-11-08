<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="ClerkDetails.css">
    <title>Clerk Details</title>
</head>
<body>

    <div class="container">
        <h2>Clerk Details</h2>
        
        <table>
            <tr>
                <th>Clerk ID</th>
                <td><%= request.getAttribute("clerkId") %></td>
            </tr>
            <tr>
                <th>Clerk Name</th>
                <td><%= request.getAttribute("clerkName") %></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><%= request.getAttribute("clerkEmail") %></td>
            </tr>
            <tr>
                <th>Phone</th>
                <td><%= request.getAttribute("clerkPhone") %></td>
            </tr>
        </table>

        <div class="button-group">
            <a href="ClerkPage.jsp" class="button">Back to Home</a>
            <a href="updateClerkDetails.jsp" class="button update-btn">Update Details</a>
        </div>
    </div>

</body>
</html>
