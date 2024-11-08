import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CitizenSignupServlet")
public class CitizenSignupServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/road_repair";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "keerthana_2126";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("citizenName");
        String email = request.getParameter("citizenEmail");
        String password = request.getParameter("citizenPassword");
        String phone = request.getParameter("citizenPhone");
        String address = request.getParameter("citizenAddress");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "INSERT INTO citizens (citizen_name, citizen_email, citizen_password, citizen_phone, citizen_address) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, phone);
            pstmt.setString(5, address);

            int rowsInserted = pstmt.executeUpdate();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            if (rowsInserted > 0) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Registration successful!');");
                out.println("window.location.href = 'CitizenPage.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('Registration failed! Try again.');");
                out.println("window.location.href = 'Citizen_Signup.jsp';");
                out.println("</script>");
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
