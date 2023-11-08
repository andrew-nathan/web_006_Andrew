import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("a".equals(username) && "b".equals(password))
        {
            response.sendRedirect("home.html");
            
            // Store the username as an attribute in the session
            session.setAttribute("username", username);
                   }
            }

}