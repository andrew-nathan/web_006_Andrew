import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class favour extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to HTML as the output will be rendered in a browser.
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the parameters from the request.
        String favoriteCuisine = request.getParameter("cuisine");
        String favoriteFood = request.getParameter("food");
        String favoriteDrink = request.getParameter("drink");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Food Preference</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Your Food Preferences</h2>");
        out.println("<p>Favorite Cuisine: " + favoriteCuisine + "</p>");
        out.println("<p>Favorite Food: " + favoriteFood + "</p>");
        out.println("<p>Favorite Drink: " + favoriteDrink + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
