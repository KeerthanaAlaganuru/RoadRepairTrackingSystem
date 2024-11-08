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

@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {

    // Database credentials and URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/road_repair";  // Replace 'road_repair' with actual database name
    private static final String DB_USER = "root";  // Replace 'root' with actual username
    private static final String DB_PASSWORD = "keerthana_2126";  // Replace 'keerthana_2126' with actual password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminId = request.getParameter("adminId");
        String adminName = request.getParameter("adminName");
        String adminEmail = request.getParameter("adminEmail");
        String adminPhone = request.getParameter("adminPhone");
        String adminPassword = request.getParameter("adminPassword");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Initialize the database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            // Prepare SQL update query
            String query = "UPDATE admin SET admin_name = ?, admin_email = ?, admin_phone = ?, admin_password = ? WHERE admin_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, adminName);
            pstmt.setString(2, adminEmail);
            pstmt.setString(3, adminPhone);
            pstmt.setString(4, adminPassword);
            pstmt.setString(5, adminId);

            // Execute the update and check the result
            int rowsUpdated = pstmt.executeUpdate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            if (rowsUpdated > 0) {
                // Generate JavaScript for popup and redirect
                out.println("<script type='text/javascript'>");
                out.println("alert('Admin details updated successfully.');");
                out.println("window.location.href = 'AdminPage.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('Failed to update admin details.');");
                out.println("window.location.href = 'AdminPage.jsp';");
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
