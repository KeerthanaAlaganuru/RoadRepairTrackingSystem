import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class CComplaintSubmissionServlet extends HttpServlet {
    
    // JDBC database credentials
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/road_repair";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "keerthana_2126";

    // SQL insert statement
    private static final String INSERT_COMPLAINT_SQL = 
        "INSERT INTO complaintsbycitizen (name, phone, location, address, complaint_type, message) VALUES (?, ?, ?, ?, ?, ?)";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get citizen's name from session
        HttpSession session = request.getSession();
        String citizenName = (String) session.getAttribute("citizenName"); // Retrieve citizen name from session
        
        // If no name found in session (i.e., user is not logged in), redirect to login page
        if (citizenName == null) {
            response.sendRedirect("Citizen_Login.jsp"); // Redirect to login page if no session found
            return;
        }
        
        // Get other form data
        String phone = request.getParameter("phone");
        String location = request.getParameter("location");
        String address = request.getParameter("issue");
        String complaintType = request.getParameter("complaint");
        String message = request.getParameter("message");

        // Create a connection and prepare statement to insert into the database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPLAINT_SQL)) {

            // Set values in the prepared statement
            preparedStatement.setString(1, citizenName);  // Name from session
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, location);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, complaintType);
            preparedStatement.setString(6, message);

            // Execute the insert query
            int result = preparedStatement.executeUpdate();
            
            // If insert is successful, show success popup and redirect back to CitizenPage
            if (result > 0) {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script type='text/javascript'>");
                out.println("alert('Complaint submitted successfully!');");
                out.println("window.location.href = 'CitizenPage.jsp';");  // Redirect back to CitizenPage
                out.println("</script>");
            } else {
                // If insert failed, show error popup and stay on the same page
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script type='text/javascript'>");
                out.println("alert('Error submitting complaint. Please try again.');");
                out.println("window.location.href = 'CitizenPage.jsp';");  // Redirect back to CitizenPage
                out.println("</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // If database error occurs, show error popup and stay on the same page
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>");
            out.println("alert('Database error occurred. Please try again.');");
            out.println("window.location.href = 'CitizenPage.jsp';");  // Redirect back to CitizenPage
            out.println("</script>");
        }
    }

    // Optional: You can implement doGet() if you want to handle GET requests.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Typically, GET method would not be used for this action, but if needed:
        response.getWriter().println("GET method is not supported for form submission.");
    }
}
