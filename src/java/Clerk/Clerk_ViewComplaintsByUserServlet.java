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

@WebServlet("/Clerk_ViewComplaintsByUserServlet")
public class Clerk_ViewComplaintsByUserServlet extends HttpServlet {
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

            // SQL query to retrieve all citizens
            String sql = "SELECT citizen_id, citizen_name, citizen_email, citizen_phone, citizen_address FROM citizens";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // List to hold the citizen data
            List<String[]> citizensList = new ArrayList<>();

            // Retrieve data from ResultSet and add it to the list
            while (rs.next()) {
                String[] citizen = new String[5];
                citizen[0] = String.valueOf(rs.getInt("citizen_id"));
                citizen[1] = rs.getString("citizen_name");
                citizen[2] = rs.getString("citizen_email");
                citizen[3] = rs.getString("citizen_phone");
                citizen[4] = rs.getString("citizen_address");
                citizensList.add(citizen);
            }

            // Set the list as a request attribute
            request.setAttribute("citizensList", citizensList);

            // Forward the request to the JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("Clerk_ViewCitizens.jsp");
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
