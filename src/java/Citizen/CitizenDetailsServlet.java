import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/CitizenDetailsServlet")
public class CitizenDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Get the citizen's email from the session
        HttpSession session = request.getSession();
        String citizenEmail = (String) session.getAttribute("citizenEmail");

        if (citizenEmail == null) {
            response.sendRedirect("Citizen_Login.jsp");
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);

            // Query to fetch citizen details using citizen email from session
            String sql = "SELECT * FROM Citizens WHERE citizen_email = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, citizenEmail);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Set the citizen details as request attributes
                request.setAttribute("citizenName", resultSet.getString("citizen_name"));
                request.setAttribute("citizenEmail", resultSet.getString("citizen_email"));
                request.setAttribute("citizenPhone", resultSet.getString("citizen_phone"));
                request.setAttribute("citizenAddress", resultSet.getString("citizen_address"));

                // Forward the request to the CitizenDetails.jsp page to display the details
                request.getRequestDispatcher("CitizenDetails.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Citizen details not found.");
                request.getRequestDispatcher("Citizen_Login.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database connection error: " + e.getMessage());
            request.getRequestDispatcher("Citizen_Login.jsp").forward(request, response);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException ignored) {}
        }
    }
}
