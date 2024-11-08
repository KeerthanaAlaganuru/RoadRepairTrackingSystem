<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RRTS - Citizen</title>
    <link rel="stylesheet" href="CitizenPage.css">
    <link rel="icon" href="Images/HomeLogo.jpg" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="CitizenPage.css"> <!-- External CSS File -->
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
                        <a class="nav-link" href="CitizenPage.jsp"><i class="bi bi-house-door"></i> Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/CitizenDetailsServlet">
                            <i class="bi bi-person-circle"></i> Profile
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/CitizenLogoutServlet">
                            <i class="bi bi-box-arrow-right"></i> Logout
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="welcome-message">
        <% 
            String citizenName = (String) session.getAttribute("citizenName");
            if (citizenName != null) {
                out.println("Welcome, " + citizenName);
            } else {
                out.println("Welcome, Guest");
            }
        %>
    </div>

    <div class="container card-container">
        <!-- Raise Complaint Card -->
        <div class="card custom-card">
            <img src="Images/filecomplaint.jpg" class="card-img-top" alt="Raise Complaint Image">
            <div class="card-body text-center">
                <h5 class="card-title">Raise a Complaint</h5>
                <p class="card-text">Click to open the form to raise a complaint</p>
                <button class="btn custom-button" onclick="openForm('Citizen_Complaint.jsp')">Open Form</button>
            </div>
        </div>

        <!-- View Complaint Status Card -->
        <div class="card custom-card" onclick="checkStatus()">
            <img src="Images/checkstatus.jpg" class="card-img-top" alt="Complaint Status Image">
            <div class="card-body text-center">
                <h5 class="card-title">View Complaint Status</h5>
                <p class="card-text">Click to check the status of your complaints</p>
                <button class="btn custom-button" data-bs-toggle="modal" data-bs-target="#statusModal">Check Status</button>
            </div>
        </div>

        <!-- View Your Complaints Card -->
        <div class="card custom-card">
            <img src="Images/viewcomplaint.jpg" class="card-img-top" alt="View Complaints Image">
            <div class="card-body text-center">
                <h5 class="card-title">View Your Complaints</h5>
                <p class="card-text">Click to see all your past complaints</p>
                <button class="btn custom-button" onclick="window.location.href='Citizen_ViewComplaintsServlet'">View Complaints</button>
            </div>
        </div>
    </div>

    <!-- Modal for Check Status -->
    <div class="modal fade" id="statusModal" tabindex="-1" aria-labelledby="statusModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="statusModalLabel">Complaint Status</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Your complaint status is being processed. Please check back later for updates.</p>
                    <!-- Add further dynamic content or links here as necessary -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        function openForm(url) {
            window.location.href = url;
        }
    </script>
</body>

</html>
