import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ClerkComplaintSubmissionServlet extends HttpServlet {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/road_repair";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "keerthana_2126";

    private static final String INSERT_COMPLAINT_SQL = 
        "INSERT INTO complaintsbyclerk (name, phone, location, address, complaint_type, message) VALUES (?, ?, ?, ?, ?, ?)";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String clerkName = (String) session.getAttribute("clerkName");

        if (clerkName == null) {
            response.sendRedirect("Clerk_Login.jsp");
            return;
        }

        String phone = request.getParameter("clerkPhone");
        String location = request.getParameter("location");
        String address = request.getParameter("issue");
        String complaintType = request.getParameter("complaintType");
        String message = request.getParameter("message");

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPLAINT_SQL)) {

            preparedStatement.setString(1, clerkName);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, location);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, complaintType);
            preparedStatement.setString(6, message);

            int result = preparedStatement.executeUpdate();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (result > 0) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Complaint submitted successfully!');");
                out.println("window.location.href = 'ClerkPage.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('Error submitting complaint. Please try again.');");
                out.println("window.location.href = 'ClerkPage.jsp';");
                out.println("</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>");
            out.println("alert('Database error occurred. Please try again.');");
            out.println("window.location.href = 'ClerkPage.jsp';");
            out.println("</script>");
        }
    }
}
