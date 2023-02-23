import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class signinvalidate extends HttpServlet
{
    public void doPost(HttpServletRequest request,HttpServletResponse rp)throws ServletException,IOException   
    {
        try
        {
            rp.setContentType("text/html");
            PrintWriter out=rp.getWriter();
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel2","root","root");  
            String email_id=request.getParameter("email_id");
            String password=request.getParameter("password");
            //PreparedStatement ps=con.prepareStatement("insert into signingin values(?,?)");
            //ps.setString(1,email_id);
            //ps.setString(2,password);
            //int i=ps.executeUpdate();
             PreparedStatement ps=con.prepareStatement("select email_id from registration3 where email_id=? and password=?");
            ps.setString(1,email_id);
            ps.setString(2,password);
            ResultSet res=ps.executeQuery();
            if(res.next())
            {
                rp.sendRedirect("book.html");
                //RequestDispatcher rd=request.getRequestDispatcher("book.html");
                //rd.forward(request,rp);
            }
            else
            {
                out.println("<font color=red size=8>Login Failed!!<br/>");
                out.println("<a href=index.html>Try Again!!!</a>");
            }
        }   
        catch(ClassNotFoundException e)
        {
             e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
 
    }
}
        
