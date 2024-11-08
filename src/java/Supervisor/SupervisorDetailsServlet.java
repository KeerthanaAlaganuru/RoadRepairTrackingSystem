import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/SupervisorDetailsServlet")
public class SupervisorDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Get the supervisorId from the session
        HttpSession session = request.getSession();
        String supervisorId = (String) session.getAttribute("supervisorId");

        // Debugging: Print the session attribute to check if supervisorId is set
        System.out.println("Supervisor ID from session: " + supervisorId);

        if (supervisorId == null) {
            // If session doesn't contain supervisorId, redirect to login page
            response.sendRedirect("Supervisor_Login.jsp");
            return;
        }

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/road_repair?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root"; 
        String password = "keerthana_2126"; 

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC driver
            connection = DriverManager.getConnection(url, user, password); // Connect to the database

            // Query to fetch supervisor details using supervisor_id from session
            String sql = "SELECT * FROM Supervisors WHERE supervisor_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, supervisorId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Set the supervisor details as request attributes
                request.setAttribute("supervisorId", resultSet.getString("supervisor_id"));
                request.setAttribute("supervisorName", resultSet.getString("supervisor_name"));
                request.setAttribute("supervisorEmail", resultSet.getString("supervisor_email"));
                request.setAttribute("supervisorPhone", resultSet.getString("supervisor_phone"));

                // Forward the request to the SupervisorDetails.jsp page to display the details
                request.getRequestDispatcher("SupervisorDetails.jsp").forward(request, response);
            } else {
                // If supervisor details are not found, show an error message
                request.setAttribute("errorMessage", "Supervisor details not found.");
                request.getRequestDispatcher("Supervisor_Login.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database connection error: " + e.getMessage());
            request.getRequestDispatcher("Supervisor_Login.jsp").forward(request, response);
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException ignored) {}
        }
    }
}
