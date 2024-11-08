<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Raised Complaints</title>
    
    <style>
        /* Basic styling for the container */
.container {
    width: 80%;
    margin: 0 auto;
    padding-top: 50px;
}

/* Heading styles */
h2, h3 {
    font-family: Arial, sans-serif;
    color: #333;
}

/* Styling for the complaint card */
.complaints-container {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr; /* Responsive 3-column grid */
    gap: 20px;
    padding-top: 20px;
}

.complaint-card {
    background-color: #f9f9f9;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.complaint-card h4 {
    font-size: 18px;
    color: #333;
}

.complaint-card p {
    color: #555;
    font-size: 14px;
    margin-top: 10px;
}

/* Styling when there are no complaints */
.no-complaints {
    color: #666;
    font-style: italic;
}

/* Link styling for Back button */
.back-btn {
    display: inline-block;
    margin-top: 20px;
    padding: 10px 20px;
    background-color: #007BFF;
    color: white;
    text-decoration: none;
    border-radius: 5px;
}

.back-btn:hover {
    background-color: #0056b3;
}

    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome, <%= session.getAttribute("clerkName") %></h2>
        <h3>Your Raised Complaints:</h3>

        <% 
            // Retrieve the complaints list from the request
            List<String> complaints = (List<String>) request.getAttribute("complaints");

            if (complaints != null && !complaints.isEmpty()) {
        %>
            <div class="complaints-container">
                <% for (String complaint : complaints) { %>
                    <div class="complaint-card">
                        <h4>Complaint Details:</h4>
                        <p><strong><%= complaint %></strong></p>
                    </div>
                <% } %>
            </div>
        <%
            } else {
        %>
            <p class="no-complaints">You have not raised any complaints yet.</p>
        <%
            }
        %>

        <a href="ClerkPage.jsp" class="back-btn">Back to Home</a>
    </div>
</body>
</html>
