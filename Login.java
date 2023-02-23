import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class Login extends HttpServlet
{
    public void doPost(HttpServletRequest rq,HttpServletResponse rp)throws IOException
    {
        rp.setContentType("text/html");
        PrintWriter pw=rp.getWriter();
        String email_id=rq.getParameter("email_id");
        String password=rq.getParameter("password");
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel2","root","root");
            PreparedStatement ps=con.prepareStatement("insert into Signingin values(?,?)");
            ps.setString(1,email_id);
            ps.setString(2,password);
            int i=ps.executeUpdate();
            pw.println(i+" Record inserted successfully");
            
        }
        catch(Exception e)
        {
            pw.println(e); 
        } 
    }
}