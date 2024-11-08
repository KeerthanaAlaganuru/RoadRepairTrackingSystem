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

@WebServlet("/UpdateClerkServlet")
public class UpdateClerkServlet extends HttpServlet {

    // Database credentials and URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/road_repair";  // Replace 'road_repair' with actual database name
    private static final String DB_USER = "root";  // Replace 'root' with actual username
    private static final String DB_PASSWORD = "keerthana_2126";  // Replace 'keerthana_2126' with actual password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data from the request
        String clerkId = request.getParameter("clerkId");
        String clerkName = request.getParameter("clerkName");
        String clerkEmail = request.getParameter("clerkEmail");
        String clerkPhone = request.getParameter("clerkPhone");
        String clerkPassword = request.getParameter("clerkPassword");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Initialize the database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            // Prepare SQL update query
            String query = "UPDATE Clerks SET clerk_name = ?, clerk_email = ?, clerk_phone = ?, clerk_password = ? WHERE clerk_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, clerkName);
            pstmt.setString(2, clerkEmail);
            pstmt.setString(3, clerkPhone);
            pstmt.setString(4, clerkPassword);
            pstmt.setString(5, clerkId);

            // Execute the update and check the result
            int rowsUpdated = pstmt.executeUpdate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            if (rowsUpdated > 0) {
                // Generate JavaScript for popup and redirect
                out.println("<script type='text/javascript'>");
                out.println("alert('Clerk details updated successfully.');");
                out.println("window.location.href = 'ClerkPage.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('Failed to update clerk details.');");
                out.println("window.location.href = 'ClerkPage.jsp';");
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
