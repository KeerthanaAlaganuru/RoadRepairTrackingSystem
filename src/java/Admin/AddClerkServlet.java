import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/AddClerkServlet")
public class AddClerkServlet extends HttpServlet {
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

        // Get the clerk details from the form
        String clerkId = request.getParameter("clerkId");
        String clerkName = request.getParameter("clerkName");
        String clerkEmail = request.getParameter("clerkEmail");
        String clerkPassword = request.getParameter("clerkPassword");
        String clerkPhone = request.getParameter("clerkPhone");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/road_repair?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root"; // Replace with your actual DB username
        String password = "keerthana_2126"; // Replace with your actual DB password

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establishing connection to the database
            connection = DriverManager.getConnection(url, user, password);

            // SQL query to insert the new clerk record
            String sql = "INSERT INTO Clerks (clerk_id, admin_id, clerk_name, clerk_email, clerk_password, clerk_phone) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the prepared statement
            preparedStatement.setString(1, clerkId);
            preparedStatement.setString(2, adminId); // Store the logged-in adminId
            preparedStatement.setString(3, clerkName);
            preparedStatement.setString(4, clerkEmail);
            preparedStatement.setString(5, clerkPassword); // Store plain password for now
            preparedStatement.setString(6, clerkPhone);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Show alert message and redirect back to AdminPage.jsp
            String message = (rowsAffected > 0) ? "Clerk added successfully!" : "Failed to add the clerk. Please try again.";
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
