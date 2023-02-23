import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.lang.*;
import java.io.*;
public class roombooking extends HttpServlet
{
    public void doPost(HttpServletRequest rq,HttpServletResponse rp)throws IOException
    {
        rp.setContentType("text/html");
        PrintWriter pw=rp.getWriter();
        String name=rq.getParameter("name");
        int pno=Integer.parseInt(rq.getParameter("pno"));
        String addr=rq.getParameter("addr");
        String email_id=rq.getParameter("email_id");
        int idproof=Integer.parseInt(rq.getParameter("idproof"));
        String cidate=rq.getParameter("cidate");
        String codate=rq.getParameter("codate");
        String rt=rq.getParameter("rt");
        int person=Integer.parseInt(rq.getParameter("person"));
        int room=Integer.parseInt(rq.getParameter("room"));
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel2","root","root");
            PreparedStatement ps=con.prepareStatement("insert into Booking values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setInt(2,pno);
            ps.setString(3,addr);
            ps.setString(4,email_id);
            ps.setInt(5,idproof);
            ps.setString(6,cidate);
            ps.setString(7,codate);
            ps.setString(8,rt);
            ps.setInt(9,person);
            ps.setInt(10,room);
            int i=ps.executeUpdate();
            pw.println("<font color=purple size=5>Booking Successfull!!!");
            con.close();
        }
        catch(Exception e)
        {
            pw.println("<font color=deepred size=5>Booking Failed!!!");
        }
        
    }
}