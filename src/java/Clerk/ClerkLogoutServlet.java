import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ClerkLogoutServlet")
public class ClerkLogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the current session, if any
        HttpSession session = request.getSession(false);

        // Check if there is an existing session
        if (session != null) {
            // Invalidate the session to log out
            session.invalidate();
        }

        // Redirect the user to the clerk login page after logout
        response.sendRedirect("Clerk_Login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Call doGet to handle both GET and POST requests for logout
        doGet(request, response);
    }
}
