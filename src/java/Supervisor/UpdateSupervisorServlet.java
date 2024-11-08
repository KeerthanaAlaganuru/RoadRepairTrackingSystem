import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateSupervisorServlet")
public class UpdateSupervisorServlet extends HttpServlet {

    // Database credentials and URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/road_repair";  // Replace 'road_repair' with actual database name
    private static final String DB_USER = "root";  // Replace 'root' with actual username
    private static final String DB_PASSWORD = "keerthana_2126";  // Replace 'keerthana_2126' with actual password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String supervisorId = request.getParameter("supervisorId");
        String supervisorName = request.getParameter("supervisorName");
        String supervisorEmail = request.getParameter("supervisorEmail");
        String supervisorPhone = request.getParameter("supervisorPhone");
        String supervisorPassword = request.getParameter("supervisorPassword");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Initialize the database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            // Prepare SQL update query
            String query = "UPDATE Supervisors SET supervisor_name = ?, supervisor_email = ?, supervisor_phone = ?, supervisor_password = ? WHERE supervisor_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, supervisorName);
            pstmt.setString(2, supervisorEmail);
            pstmt.setString(3, supervisorPhone);
            pstmt.setString(4, supervisorPassword);
            pstmt.setString(5, supervisorId);

            // Execute the update and check the result
            int rowsUpdated = pstmt.executeUpdate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            if (rowsUpdated > 0) {
                // Generate JavaScript for popup and redirect
                out.println("<script type='text/javascript'>");
                out.println("alert('Supervisor details updated successfully.');");
                out.println("window.location.href = 'SupervisorPage.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('Failed to update supervisor details.');");
                out.println("window.location.href = 'SupervisorPage.jsp';");
                out.println("</script>");
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
