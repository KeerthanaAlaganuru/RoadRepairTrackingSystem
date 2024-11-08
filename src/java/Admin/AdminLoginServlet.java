import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String adminId = request.getParameter("admin_id");
        String adminPassword = request.getParameter("admin_password");

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

            // SQL query to verify admin credentials and retrieve the admin name
            String sql = "SELECT admin_name FROM Admin WHERE admin_id = ? AND admin_password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, adminId);
            preparedStatement.setString(2, adminPassword);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve admin name
                String adminName = resultSet.getString("admin_name");

                // Successful login, set adminId and adminName in the session
                HttpSession session = request.getSession();
                session.setAttribute("adminId", adminId); // Store adminId in session
                session.setAttribute("adminName", adminName); // Store adminName in session

                // Redirect to AdminPage.jsp
                response.sendRedirect("AdminPage.jsp");
            } else {
                // Invalid login, redirect to login page with an error message
                request.setAttribute("errorMessage", "Invalid ID or password.");
                request.getRequestDispatcher("Admin_Login.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
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
