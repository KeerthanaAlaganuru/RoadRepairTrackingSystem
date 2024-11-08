<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Road Repair Reports</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .button-container {
            margin: 20px 0;
        }
        .back-button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            text-decoration: none;
        }
        .back-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Road Repair Reports</h1>

    <!-- Back to Home Button -->
    <div class="button-container">
        <a href="<%= request.getContextPath() %>/AdminPage.jsp" class="back-button">Back to Home</a>
    </div>

    <table>
        <tr>
            <th>Report ID</th>
            <th>Road Location</th>
            <th>Complaint Type</th>
            <th>Raw Material</th>
            <th>Machine Required</th>
            <th>Labour Count</th>
            <th>Priority</th>
        </tr>

        <%
            // Database connection details
            String dbUrl = "jdbc:mysql://localhost:3306/road_repair"; // Replace with your database URL
            String dbUser = "root"; // Replace with your database username
            String dbPassword = "keerthana_2126"; // Replace with your database password

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                // Establish connection
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                
                // Create a SQL statement
                stmt = conn.createStatement();
                
                // Execute the SQL query to retrieve all records
                String sql = "SELECT * FROM road_repair_reports";
                rs = stmt.executeQuery(sql);

                // Loop through each row in the result set and display it in the table
                while (rs.next()) {
                    int reportId = rs.getInt("report_id");
                    String roadLocation = rs.getString("road_location");
                    String complaintType = rs.getString("complaint_type");
                    String rawMaterial = rs.getString("raw_material");
                    String machineRequired = rs.getString("machine_required");
                    int labourCount = rs.getInt("labour_count");
                    int priority = rs.getInt("priority");
        %>
                    <tr>
                        <td><%= reportId %></td>
                        <td><%= roadLocation %></td>
                        <td><%= complaintType %></td>
                        <td><%= rawMaterial %></td>
                        <td><%= machineRequired %></td>
                        <td><%= labourCount %></td>
                        <td><%= priority %></td>
                    </tr>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
        %>
                <tr>
                    <td colspan="7" style="color: red; text-align: center;">An error occurred while retrieving the reports.</td>
                </tr>
        <%
            } finally {
                // Close resources
                if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
                if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
                if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
            }
        %>
    </table>
</body>
</html>
