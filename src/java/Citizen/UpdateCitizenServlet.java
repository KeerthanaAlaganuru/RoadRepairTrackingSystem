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
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateCitizenServlet")
public class UpdateCitizenServlet extends HttpServlet {

    // Database credentials and URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/road_repair";  // Replace 'road_repair' with actual database name
    private static final String DB_USER = "root";  // Replace 'root' with actual username
    private static final String DB_PASSWORD = "keerthana_2126";  // Replace 'keerthana_2126' with actual password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve citizen email from the session
        HttpSession session = request.getSession();
        String citizenEmail = (String) session.getAttribute("citizenEmail");
        
        // Check if email is null or not set in session
        if (citizenEmail == null) {
            response.getWriter().println("Error: No session found. Please log in.");
            return;
        }

        // Get other details from the request parameters
        String citizenName = request.getParameter("citizenName");
        String citizenPhone = request.getParameter("citizenPhone");
        String citizenPassword = request.getParameter("citizenPassword");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Initialize the database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            // Prepare SQL update query using email to identify the citizen
            String query = "UPDATE Citizens SET citizen_name = ?, citizen_phone = ?, citizen_password = ? WHERE citizen_email = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, citizenName);
            pstmt.setString(2, citizenPhone);
            pstmt.setString(3, citizenPassword);
            pstmt.setString(4, citizenEmail); // Update using email

            // Execute the update and check the result
            int rowsUpdated = pstmt.executeUpdate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            if (rowsUpdated > 0) {
                // Generate JavaScript for popup and redirect
                out.println("<script type='text/javascript'>");
                out.println("alert('Citizen details updated successfully.');");
                out.println("window.location.href = 'CitizenPage.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('Failed to update citizen details.');");
                out.println("window.location.href = 'CitizenPage.jsp';");
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
