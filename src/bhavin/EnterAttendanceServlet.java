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

@WebServlet("/EnterAttendanceServlet")
public class EnterAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static int counter = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
        
        String n = request.getParameter("UserName");
        String p = request.getParameter("Password");
        String c = request.getParameter("Cname");
        
        
        int stat= TeacherDao.check(n,p);
        System.out.println("status" +stat);
        if(stat==1){
        	
        	writer.println("Welcome"+n);
            HttpSession Session = request.getSession();
            Session.setAttribute("UserName", n);
            Session.setAttribute("Cname", c);
        
        	writer.println("<head><link rel='stylesheet' type ='text/css' href='attendance_filling_page.css'><link href='https://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'></head>");
    		writer.println("<h1>Enter Attendance of Students</h1>");
    		writer.println("<body>");
    		List<Student> list = StudentAttendanceDao.getAllStudent(c);
    		 for(Student s:list){
    			writer.println("<div class ='maxl'>");
    	    	writer.println("<p class = 'h'>Uid : "+s.getUId()+"<br>   Name : "+s.getName()+"<br>   Course Name:"+s.getCname()+"<br><p>");  
    	    	writer.println("<form action='AttendanceServletToDatabase' method = 'post'>");
    	  		writer.println("<label class ='radio inline'><input type='radio' name='"+s.getUId()+"' value='P'><span>Present</span><br></label>");
    	  		writer.println("<label class ='radio inline'><input type='radio' name='"+s.getUId()+"' value='A'><span>Absent</span><br></label>");
    	  		writer.println("</div>");
    	  		}
    		 writer.println("<p class = 'maxl'><input type='submit'  class='btn-style' value='Submit'></p></form>");
    		
    			writer.println("</body>");
	
        }
        
        else{
            writer.println("Sorry!!!,Username or password is Wrong");
            request.getRequestDispatcher("teacher.html").include(request, response);
        }
        writer.close();
        }catch(Exception ex){ex.printStackTrace();}
}

}

