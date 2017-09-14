package bhavin;


/**
 * Servlet implementation class Servlet
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			
			
			
			String n = request.getParameter("UserName");
			String p = request.getParameter("Password");
			String c = request.getParameter("Cname");
			String dFrom = request.getParameter("datefrom");
			String dTO = request.getParameter("dateto");
			System.out.println(dFrom+dTO);
			
			
			//int status  = check(n,p);
			int check=StudentDao.check(n,p);
			if(check!=0){
				 writer.println("<link rel='stylesheet' type='text/css' href='servlet.css'>");
				  writer.println("<body>");
				  writer.println("<div class='error50'>");
				writer.println("Welcome   "+n);
				writer.println("</div>");
				HttpSession Session = request.getSession();
				 writer.println("<div class='error51'>");
				Session.setAttribute("UserName", n);
				writer.println("</div>");
				List<Attendance> list = AttendanceDao.getAllAttendanceDetail(n, p, c, dFrom, dTO);
			      
			      writer.print("<table id='customers'");  
			      writer.print("<tr><th>Course</th><th>Status</th><th>Date</th></tr>");  
			      
			      for(Attendance a:list){
			    	  writer.print("<tr><td>"+a.getCname()+"</td><td>"+a.getStatus()+"</td><td>"+a.getDate()+"</td></tr>"); 
			    	  
			    	 
			      }
			      writer.println("</table>");
			      writer.println("<a href='Servlet2' class='button'>Log Out</a>");
			      writer.println("</body>");
			}
			else{
				writer.println("Sorry!!!,Username or password is Wrong");
				request.getRequestDispatcher("student.html").include(request, response);
			}
			
			writer.close();
			}catch(Exception ex){ex.printStackTrace();}
	}

}
