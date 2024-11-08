import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/AdminDetailsServlet")
public class AdminDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Get the adminId from the session
        HttpSession session = request.getSession();
        String adminId = (String) session.getAttribute("adminId");

        // Debugging: Print the session attribute to check if adminId is set
        System.out.println("Admin ID from session: " + adminId);

        if (adminId == null) {
            // If session doesn't contain adminId, redirect to login page
            response.sendRedirect("Admin_Login.jsp");
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

            // Query to fetch admin details using admin_id from session
            String sql = "SELECT * FROM Admin WHERE admin_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, adminId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Set the admin details as request attributes
                request.setAttribute("adminId", resultSet.getString("admin_id"));
                request.setAttribute("adminName", resultSet.getString("admin_name"));
                request.setAttribute("adminEmail", resultSet.getString("admin_email"));
                request.setAttribute("adminPhone", resultSet.getString("admin_phone"));

                // Forward the request to the AdminDetails.jsp page to display the details
                request.getRequestDispatcher("AdminDetails.jsp").forward(request, response);
            } else {
                // If admin details are not found, show an error message
                request.setAttribute("errorMessage", "Admin details not found.");
                request.getRequestDispatcher("Admin_Login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database connection error: " + e.getMessage());
            request.getRequestDispatcher("Admin_Login.jsp").forward(request, response);
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
