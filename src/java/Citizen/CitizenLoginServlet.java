import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
@WebServlet("/CitizenLoginServlet")
public class CitizenLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String citizenEmail = request.getParameter("citizen_email");
        String citizenPassword = request.getParameter("citizen_password");

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

            // SQL query to verify citizen credentials
            String sql = "SELECT * FROM citizens WHERE citizen_email = ? AND citizen_password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, citizenEmail);
            preparedStatement.setString(2, citizenPassword);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Successful login, retrieve citizen's name
                String citizenName = resultSet.getString("citizen_name"); // Assuming column is 'citizen_name'

                // Set citizen's email and name in session
                HttpSession session = request.getSession();
                session.setAttribute("citizenEmail", citizenEmail); // Store citizenEmail in session
                session.setAttribute("citizenName", citizenName);   // Store citizenName in session

                // Debugging output to check if session is set
                System.out.println("Session ID: " + session.getId()); 
                
                // Redirect to CitizenPage.jsp to display citizen's home page
                System.out.println("Redirecting to CitizenPage.jsp...");
                response.sendRedirect("CitizenPage.jsp");
            } else {
                // Invalid login, redirect to login page with an error message
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("Citizen_Login.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database connection error: " + e.getMessage());
            request.getRequestDispatcher("Citizen_Login.jsp").forward(request, response);
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
