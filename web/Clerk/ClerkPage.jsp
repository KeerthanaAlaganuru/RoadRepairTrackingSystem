<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RRTS - Clerk</title>
    <link rel="icon" href="Images/HomeLogo.jpg" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="ClerkPage.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="HomePage.jsp">
                <img src="Images/HomeLogo.jpg" alt="Logo" class="img-fluid rounded-circle navbar-logo">
                <span class="navbar-text">RoadRepair</span>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" 
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="ClerkPage.jsp"><i class="bi bi-house-door"></i> Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/ClerkDetailsServlet">
                            <i class="bi bi-person-circle"></i> Profile
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/ClerkLogoutServlet">
                            <i class="bi bi-box-arrow-right"></i> Logout
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
     
     <div class="welcome-message">
        <% 
            String clerkName = (String) session.getAttribute("clerkName");
            if (clerkName != null) {
                out.println("Welcome, " + clerkName);
            } else {
                out.println("Welcome, Guest");
            }
        %>
    </div>

    <!-- Main Content -->
    <div class="container card-container mt-5 pt-5">
        <!-- View Complaints by User Card -->
        <div class="card custom-card" onclick="window.location.href='<%= request.getContextPath() %>/Clerk_ViewComplaintsByUserServlet'">
            <img src="Images/form2.jpg" class="card-img-top" alt="View Complaints by User">
            <div class="card-body text-center">
                <h5 class="card-title">View Complaints by User</h5>
                <p class="card-text">Click to view complaints raised by users.</p>
                <button class="btn custom-button" >View Complaints</button>
            </div>
        </div>

        <!-- Raise Complaints Card (if needed for Clerk) -->
        <div class="card custom-card">
            <img src="Images/filecomplaint.jpg" class="card-img-top" alt="Raise Complaint">
            <div class="card-body text-center">
                <h5 class="card-title">Raise a Complaint</h5>
                <p class="card-text">Click the button below to open the form to raise a complaint.</p>
                <button class="btn custom-button" onclick="window.location.href='Clerk_Complaint.jsp'">Open Form</button>
            </div>
        </div>

        <!-- View Your Complaints Card -->
       <div class="card custom-card">
            <img src="Images/viewcomplaint.jpg" class="card-img-top" alt="View Your Complaints">
            <div class="card-body text-center">
                <h5 class="card-title">View Your Complaints</h5>
                <p class="card-text">Click to view the complaints you've raised.</p>
                <!-- Move the onclick to the button -->
                <button class="btn custom-button" onclick="window.location.href='<%= request.getContextPath() %>/Clerk_ViewComplaintsServlet'">View Complaints</button>
            </div>
        </div>


        

    </div>

    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
