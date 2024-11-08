import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/DeleteClerkServlet")
public class DeleteClerkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clerkId = request.getParameter("clerkId");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/road_repair?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root"; // Replace with your actual DB username
        String password = "keerthana_2126"; // Replace with your actual DB password

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establishing connection to the database
            connection = DriverManager.getConnection(url, user, password);

            // SQL query to delete the clerk record
            String sql = "DELETE FROM Clerks WHERE clerk_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, clerkId);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // If clerk is deleted successfully, redirect to AdminPage.jsp with success message
                response.sendRedirect("AdminPage.jsp?message=Clerk deleted successfully");
            } else {
                // If no clerk with the given ID is found, send failure message
                response.sendRedirect("AdminPage.jsp?message=Clerk not found");
            }
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            response.sendRedirect("AdminPage.jsp?message=Error deleting clerk");
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException ignored) {}
        }
    }
}
