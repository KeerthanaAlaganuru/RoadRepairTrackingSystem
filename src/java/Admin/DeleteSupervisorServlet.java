
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/DeleteSupervisorServlet")
public class DeleteSupervisorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String supervisorId = request.getParameter("supervisorId");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/road_repair?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root"; // Replace with your actual DB username
        String password = "keerthana_2126"; // Replace with your actual DB password

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establishing connection to the database
            connection = DriverManager.getConnection(url, user, password);

            // SQL query to delete the supervisor record
            String sql = "DELETE FROM Supervisors WHERE supervisor_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, supervisorId);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // If supervisor is deleted successfully, redirect to AdminPage.jsp with success message
                response.sendRedirect("AdminPage.jsp?message=Supervisor deleted successfully");
            } else {
                // If no supervisor with the given ID is found, send failure message
                response.sendRedirect("AdminPage.jsp?message=Supervisor not found");
            }
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            response.sendRedirect("AdminPage.jsp?message=Error deleting supervisor");
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException ignored) {}
        }
    }
}
