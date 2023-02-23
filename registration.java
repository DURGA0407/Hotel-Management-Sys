import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class registration extends HttpServlet
{
    public void doPost(HttpServletRequest rq,HttpServletResponse rp)throws IOException
    {
        rp.setContentType("text/html");
        PrintWriter pw=rp.getWriter();
        String name=rq.getParameter("name");
        String email_id=rq.getParameter("email_id");
        String pass=rq.getParameter("pass");
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel2","root","root");
            PreparedStatement ps=con.prepareStatement("insert into Registration3 values(?,?,?)");
            ps.setString(1,name);
            ps.setString(2,email_id);
            ps.setString(3,pass);
            int i=ps.executeUpdate();
            pw.println("<font color=green size=5>Account created successfully!!!");
        }
        catch(Exception e)
        {
            pw.println("Already have an account"); 
        } 
    }
}