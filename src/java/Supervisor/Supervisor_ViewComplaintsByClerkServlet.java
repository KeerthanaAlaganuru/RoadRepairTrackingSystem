import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Supervisor_ViewComplaintsByClerkServlet")
public class Supervisor_ViewComplaintsByClerkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/road_repair"; // Use your database name
    private static final String JDBC_USERNAME = "root"; // Your DB username
    private static final String JDBC_PASSWORD = "keerthana_2126"; // Your DB password

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type of the response
        response.setContentType("text/html;charset=UTF-8");

        // Database resources
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

            // SQL query to retrieve all complaints by clerks
            String sql = "SELECT complaint_id, name, phone, location, address, complaint_type, message, created_at FROM complaintsbyclerk";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // List to hold the complaint data
            List<String[]> complaintsList = new ArrayList<>();

            // Retrieve data from ResultSet and add it to the list
            while (rs.next()) {
                String[] complaint = new String[8];
                complaint[0] = String.valueOf(rs.getInt("complaint_id"));
                complaint[1] = rs.getString("name");
                complaint[2] = rs.getString("phone");
                complaint[3] = rs.getString("location");
                complaint[4] = rs.getString("address");
                complaint[5] = rs.getString("complaint_type");
                complaint[6] = rs.getString("message");
                complaint[7] = rs.getString("created_at");
                complaintsList.add(complaint);
            }

            // Set the list as a request attribute
            request.setAttribute("complaintsList", complaintsList);

            // Forward the request to the JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("Supervisor_ViewClerkComplaints.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean up database resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
