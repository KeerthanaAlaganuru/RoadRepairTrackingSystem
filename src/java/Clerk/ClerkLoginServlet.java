import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/ClerkLoginServlet")
public class ClerkLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clerkId = request.getParameter("clerk_id");
        String clerkPassword = request.getParameter("clerk_password");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/road_repair?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root"; // Replace with your actual DB username
        String password = "keerthana_2126"; // Replace with your actual DB password

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Explicitly loading the JDBC driver if necessary
            Class.forName("com.mysql.cj.jdbc.Driver"); // Optional, depending on the version

            // Establishing connection to the database
            connection = DriverManager.getConnection(url, user, password);

            // SQL query to verify clerk credentials and retrieve clerk details
            String sql = "SELECT clerk_id, clerk_name FROM Clerks WHERE clerk_id = ? AND clerk_password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, clerkId);
            preparedStatement.setString(2, clerkPassword);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Successful login, retrieve clerkName and set both clerkId and clerkName in the session
                String clerkName = resultSet.getString("clerk_name");

                HttpSession session = request.getSession();
                session.setAttribute("clerkId", clerkId); // Store clerkId in session
                session.setAttribute("clerkName", clerkName); // Store clerkName in session

                // Redirect to ClerkPage.jsp (or dashboard) after successful login
                response.sendRedirect("ClerkPage.jsp");
            } else {
                // Invalid login, redirect to login page with an error message
                request.setAttribute("errorMessage", "Invalid ID or password.");
                request.getRequestDispatcher("Clerk_Login.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
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
