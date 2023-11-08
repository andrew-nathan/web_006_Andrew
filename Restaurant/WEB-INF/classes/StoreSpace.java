import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class StoreSpace extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String food = request.getParameter("food");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.18.0.2:3306/space","root","10022004");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into space values('" + name + "','" + food + "')");
            stmt.close();
            con.close();
            PrintWriter out = response.getWriter();
            out.println("<html><head>");
            out.println("<link rel='stylesheet' href='style.css' /> <title>Store food</title></head>");
            out.println("<body class='flex-col'><h1>food Database</h1>");
            out.println("<h2>food added successfully</h2>");
            out.println("<a href='accessspace'>Click here to see the database</a>");
            out.println("</body></html>");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}