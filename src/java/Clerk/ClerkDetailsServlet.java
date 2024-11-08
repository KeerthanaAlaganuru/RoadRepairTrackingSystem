import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ClerkDetailsServlet")
public class ClerkDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Get the clerkId from the session
        HttpSession session = request.getSession();
        String clerkId = (String) session.getAttribute("clerkId");

        // Debugging: Print the session attribute to check if clerkId is set
        System.out.println("Clerk ID from session: " + clerkId);

        if (clerkId == null) {
            // If session doesn't contain clerkId, redirect to login page
            response.sendRedirect("Clerk_Login.jsp");
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

            // Query to fetch clerk details using clerk_id from session
            String sql = "SELECT * FROM Clerks WHERE clerk_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, clerkId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Set the clerk details as request attributes
                request.setAttribute("clerkId", resultSet.getString("clerk_id"));
                request.setAttribute("clerkName", resultSet.getString("clerk_name"));
                request.setAttribute("clerkEmail", resultSet.getString("clerk_email"));
                request.setAttribute("clerkPhone", resultSet.getString("clerk_phone"));

                // Forward the request to the ClerkDetails.jsp page to display the details
                request.getRequestDispatcher("ClerkDetails.jsp").forward(request, response);
            } else {
                // If clerk details are not found, show an error message
                request.setAttribute("errorMessage", "Clerk details not found.");
                request.getRequestDispatcher("Clerk_Login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database connection error: " + e.getMessage());
            request.getRequestDispatcher("Clerk_Login.jsp").forward(request, response);
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
