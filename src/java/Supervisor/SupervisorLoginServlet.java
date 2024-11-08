import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/SupervisorLoginServlet")
public class SupervisorLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String supervisorId = request.getParameter("supervisor_id");
        String supervisorPassword = request.getParameter("supervisor_password");

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

            // SQL query to verify supervisor credentials and retrieve supervisor details
            String sql = "SELECT supervisor_id, supervisor_name FROM Supervisors WHERE supervisor_id = ? AND supervisor_password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, supervisorId);
            preparedStatement.setString(2, supervisorPassword);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Successful login, retrieve supervisorName and set both supervisorId and supervisorName in the session
                String supervisorName = resultSet.getString("supervisor_name");

                HttpSession session = request.getSession();
                session.setAttribute("supervisorId", supervisorId); // Store supervisorId in session
                session.setAttribute("supervisorName", supervisorName); // Store supervisorName in session

                // Redirect to Supervisor Dashboard page
                response.sendRedirect("SupervisorPage.jsp");
            } else {
                // Invalid login, redirect to login page with an error message
                request.setAttribute("errorMessage", "Invalid ID or password.");
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
