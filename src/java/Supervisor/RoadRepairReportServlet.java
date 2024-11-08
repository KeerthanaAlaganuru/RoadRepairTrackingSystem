import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RoadRepairReportServlet")
public class RoadRepairReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String roadLocation = request.getParameter("road_location");
        String complaintType = request.getParameter("complaint_type");
        String rawMaterial = request.getParameter("raw_material");
        String machineRequired = request.getParameter("machine_required");
        int labourCount = Integer.parseInt(request.getParameter("labour_count"));
        int priority = Integer.parseInt(request.getParameter("priority"));
        
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/road_repair"; 
            String dbUser = "root";
            String dbPassword = "keerthana_2126";

            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            String sql = "INSERT INTO road_repair_reports (road_location, complaint_type, raw_material, machine_required, labour_count, priority) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, roadLocation);
            stmt.setString(2, complaintType);
            stmt.setString(3, rawMaterial);
            stmt.setString(4, machineRequired);
            stmt.setInt(5, labourCount);
            stmt.setInt(6, priority);

            stmt.executeUpdate();
            
            stmt.close();
            conn.close();

            // Redirect to the success page after successful insertion
            response.sendRedirect("SupervisorPage.jsp");

        } catch (Exception e) {
            // If an error occurs, send JavaScript response to show an alert and redirect
            response.setContentType("text/html");
            response.getWriter().println("<script type='text/javascript'>");
            response.getWriter().println("alert('Failed to submit the form.');");
            response.getWriter().println("window.location.href = 'supervisorPage.jsp';");
            response.getWriter().println("</script>");
        }
    }
}
