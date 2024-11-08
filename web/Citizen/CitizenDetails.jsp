<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CitizenDetails.css">
    <title>Citizen Details</title>
</head>
<body>

    <div class="container">
        <h2>Citizen Details</h2>
        
        <table>
            <tr>
                <th>Citizen Name</th>
                <td><%= request.getAttribute("citizenName") %></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><%= request.getAttribute("citizenEmail") %></td>
            </tr>
            <tr>
                <th>Phone</th>
                <td><%= request.getAttribute("citizenPhone") %></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><%= request.getAttribute("citizenAddress") %></td>
            </tr>
        </table>

        <div class="button-group">
            <a href="CitizenPage.jsp" class="button">Back to Home</a>
            <a href="updateCitizenDetails.jsp" class="button update-btn">Update Details</a>
            
        </div>
    </div>

</body>
</html>
