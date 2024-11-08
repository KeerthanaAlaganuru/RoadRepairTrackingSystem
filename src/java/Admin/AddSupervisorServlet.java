import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/AddSupervisorServlet")
public class AddSupervisorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the logged-in adminId from session
        HttpSession session = request.getSession();
        String adminId = (String) session.getAttribute("adminId");

        if (adminId == null) {
            // If no admin is logged in, redirect to login page
            response.sendRedirect("Admin_Login.jsp");
            return;
        }

        // Get the supervisor details from the form
        String supervisorId = request.getParameter("supervisor_id");
        String supervisorName = request.getParameter("supervisor_name");
        String supervisorEmail = request.getParameter("supervisor_email");
        String supervisorPassword = request.getParameter("supervisor_password");
        String supervisorPhone = request.getParameter("supervisor_phone");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/road_repair?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root"; // Replace with your actual DB username
        String password = "keerthana_2126"; // Replace with your actual DB password

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establishing connection to the database
            connection = DriverManager.getConnection(url, user, password);

            // SQL query to insert the new supervisor record
            String sql = "INSERT INTO Supervisors (supervisor_id, admin_id, supervisor_name, supervisor_email, supervisor_password, supervisor_phone) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the prepared statement
            preparedStatement.setString(1, supervisorId);
            preparedStatement.setString(2, adminId); // Store the logged-in adminId
            preparedStatement.setString(3, supervisorName);
            preparedStatement.setString(4, supervisorEmail);
            preparedStatement.setString(5, supervisorPassword); // Store plain password for now
            preparedStatement.setString(6, supervisorPhone);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Show alert message and redirect back to AdminPage.jsp
            String message = (rowsAffected > 0) ? "Supervisor added successfully!" : "Failed to add the supervisor. Please try again.";
            response.setContentType("text/html");
            response.getWriter().write("<script type='text/javascript'>"
                + "alert('" + message + "');"
                + "window.location.href = 'AdminPage.jsp';"
                + "</script>");

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exceptions
            response.setContentType("text/html");
            response.getWriter().write("<script type='text/javascript'>"
                + "alert('Database error: " + e.getMessage() + "');"
                + "window.location.href = 'AdminPage.jsp';"
                + "</script>");
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException ignored) {}
        }
    }
}
