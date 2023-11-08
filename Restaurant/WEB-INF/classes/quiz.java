import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class quiz extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try{
        PrintWriter out = response.getWriter();
        Connection conn=null;
        Statement stmt=null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://172.18.0.3:3306/college","root", "10022004");
        stmt = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement("insert into user values(?,?,?,?,?)");
        // Retrieve the answers from the request
        String[] answers = new String[5];
        answers[0] = request.getParameter("answer1");
        answers[1] = request.getParameter("answer2");
        answers[2] = request.getParameter("answer3");
        answers[3] = request.getParameter("answer4");
        answers[4] = request.getParameter("answer5");
        pstmt.setString(1, answers[0]);
        pstmt.setString(2, answers[1]);
        pstmt.setString(3, answers[2]);
        pstmt.setString(4, answers[3]);
        pstmt.setString(5, answers[4]);
        pstmt.executeUpdate();
        out.println("<html><body><p> Database Updated</p>");  
        response.setContentType("text/html");
        
        String sql = "SELECT * FROM user";
        pstmt = conn.prepareStatement(sql);
        //pstmt.setString(1, department);
        ResultSet rs = pstmt.executeQuery();
        // Extract data from result set
        while(rs.next())
        {
        //Retrieve by column name
        String did = rs.getString("answer");
        
        
        //Display values
        out.println("<p> answer: " + did + "<br>");
               
        }
        out.println("</body></html>");
        // Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
    }catch(Exception e){
        System.out.println(e);
    }
        
    }
}
