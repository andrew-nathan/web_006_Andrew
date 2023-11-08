/*to set cookies*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class cook extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
     try{
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String in_data = request.getParameter("uname");
        
        Cookie c = new Cookie("Ucookie",in_data);      

        response.addCookie(c);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>cookie Preference</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Your cookie Preferences</h2>");
        out.println("<p>Favorite Cookie: " + in_data + "</p>");
        out.println("</body>");
        out.println("</html>");

        //pwriter.print("<a href='Sessions2'>view details</a>");
      
        out.close();
    }
     catch(Exception exp){
       System.out.println(exp);
     }
  }
}


/*
HTTP/1.1 200 OK
Date: Fri, 04 Feb 2000 21:03:38 GMT
Server: Apache/1.3.9 (UNIX) PHP/4.0b3
Set-Cookie: name = xyz; expires = Friday, 04-Feb-07 22:03:38 GMT; 
   path = /; domain = licet.ac.in
Connection: close
Content-Type: text/html
*/




