import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class Admin extends HttpServlet
{
    public void doPost(HttpServletRequest rq,HttpServletResponse rp)throws IOException
    {
        PrintWriter pw=rp.getWriter();
        String email_id=rq.getParameter("email_id");
        String pass=rq.getParameter("pass");
        //pw.println("<h1>Displaying the customer's details</h1>");
        //pw.println("<table border='1'><tr><th>Name</th><th>Email ID</th><tr>");
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel2","root","root");
            
            Statement stmt=con.createStatement();
            //ResultSet rs1=stmt.executeQuery("select * from registration3");
            ResultSet rs2=stmt.executeQuery("Select * from booking");
            /*while(rs1.next())
            {
                pw.print("<tr><td>");
                pw.println(rs1.getString("name"));
                pw.print("<td>");
                //pw.println("<td>");
                pw.print(rs1.getString("email_id"));
                pw.print("<td>");
                pw.print("<tr>");
            }*/
                
                pw.print("<br/><br/>");
            pw.print("<h1>Details of customers who have booked rooms</h1>");
            pw.println("<table border='2'><tr><th>Name</th><th>Phone No</th><th>Address</th><th>Email ID</th><th>ID No</th><th>Check in date</th><th>Check out date</th><th>Room Type</th><th>No of person</th><th>No of rooms</th><tr>");
            while(rs2.next())
            {
                pw.print("<tr><td>");
                pw.println(rs2.getString("name"));
                pw.print("<td>");
                //pw.println("<td>");
                pw.print(rs2.getString("phone_no"));
                pw.print("<td>");
                pw.print(rs2.getString("address"));
                pw.print("<td>");
                pw.print(rs2.getString("email_id"));
                pw.print("<td>");
                pw.print(rs2.getString("id"));
                pw.print("<td>");
                pw.print(rs2.getString("check_in_date"));
                pw.print("<td>");
                pw.print(rs2.getString("check_out_date"));
                pw.print("<td>");
                pw.print(rs2.getString("room_type"));
                pw.print("<td>");
                pw.print(rs2.getString("no_of_persons"));
                pw.print("<td>");
                pw.print(rs2.getString("no_of_rooms"));
                pw.print("<td>");
                pw.print("<tr>");
            } 
             
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        pw.print("<table>");
    }
}