package bhavin;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AttendanceServletToDatabase")
public class AttendanceServletToDatabase extends HttpServlet {
	int i =0;
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session=request.getSession(false);
        String n=(String)session.getAttribute("Cname");
        
        
		List<Student> list = StudentAttendanceDao.getAllStudent(n);
        
		Attendance a = new Attendance();

		for(Student s:list)
        {
        	String Student_status=request.getParameter(Integer.toString(s.getUId()));  
        	System.out.println(Student_status);
        	a.setUid(s.getUId());
        	a.setCname(s.getCname());
        	a.setStatus(Student_status);
        	long millis=System.currentTimeMillis();  
           java.sql.Date date=new java.sql.Date(millis);
        	a.setDate(date);
        	StudentAttendanceDao.InsertAttendance(a);
        }
		writer.println("<link rel='stylesheet' type='text/css' href='attendance_success.css'>");
		writer.println("<body>");
		writer.println("<div class='full-screen'>");
		writer.println("<div>");
		writer.println("<h1>Attendance has been successfully entered</h1>");
		writer.println("<br>");
		writer.println("<a class='button-line' href='Servlet2'>Logout</a> ");
		writer.println("</div>");
		writer.println("</div>");
		writer.println("</body>");
	 
	}

}
