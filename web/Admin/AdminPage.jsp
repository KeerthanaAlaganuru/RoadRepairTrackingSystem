<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RRTS</title>
    <link rel="icon" href="Images/HomeLogo.jpg" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="AdminPage.css">
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
                        <a class="nav-link" href="AdminPage.jsp"><i class="bi bi-house-door"></i> Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/AdminDetailsServlet">
                            <i class="bi bi-person-circle"></i> Profile
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/AdminLogoutServlet">
                            <i class="bi bi-box-arrow-right"></i> Logout
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="welcome-message text-center mt-5 pt-5">
        <% 
            String adminName = (String) session.getAttribute("adminName");
            if (adminName != null) {
                out.println("Welcome, " + adminName);
            } else {
                out.println("Welcome, Guest");
            }
        %>
    </div>

    <!-- Main Content -->
    <div class="container d-flex justify-content-evenly mt-4">
        <!-- Manage Supervisors -->
        <div class="flex-box">
            <h4>Manage Supervisors</h4>
            <button class="btn custom-button" data-bs-toggle="modal" data-bs-target="#manageSupervisorsModal">
                Click Here
            </button>
        </div>

        <!-- Manage Clerks -->
        <div class="flex-box">
            <h4>Manage Clerks</h4>
            <button class="btn custom-button" data-bs-toggle="modal" data-bs-target="#manageClerksModal">
                Click Here
            </button>
        </div>

        <!-- View Road Report -->
        <div class="flex-box">
            <h4>View Road Report</h4>
            <button class="btn custom-button" onclick="window.location.href='showRoadReportToAdmin.jsp'">
                Click Here
            </button>
        </div>
    </div>
<!-- Manage Supervisors Modal -->
<div class="modal fade" id="manageSupervisorsModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="manageSupervisorsModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="manageSupervisorsModalLabel">Manage Supervisors</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <button class="btn btn-primary" onclick="window.location.href='AddSupervisor.jsp'">Add Supervisor</button>
                <button class="btn btn-danger" onclick="window.location.href='DeleteSupervisor.jsp'">Delete Supervisor</button>
            </div>
        </div>
    </div>
</div>

<!-- Manage Clerks Modal -->
<div class="modal fade" id="manageClerksModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="manageClerksModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="manageClerksModalLabel">Manage Clerks</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <button class="btn btn-primary" onclick="window.location.href='AddClerk.jsp'">Add Clerk</button>
                <button class="btn btn-danger" onclick="window.location.href='DeleteClerk.jsp'">Delete Clerk</button>
            </div>
        </div>
    </div>
</div>


    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    
</body>
</html>
