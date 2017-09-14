package bhavin;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServelet
 */
@WebServlet("/ViewServelet")
public class ViewServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<link rel='stylesheet' type='text/css' href='viewservelet.css'>");
	        out.println("<body>");
	         
	        out.println("<h1>Student List</h1>");  
	          
	        List<Student> list=new ArrayList<Student>();
	    	list = StudentDao.getAllStudents();  
	          
	        out.print("<table id='customers'>");  
	        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Course</th></tr>");  
	        for(Student e:list){  
	         out.print("<tr><td>"+e.getUId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getCname()+"</td></tr>");  
	        }  
	        out.print("</table>");
	        out.println("<a href='add_student.html' class='button'>Add New Student</a>");
	        out.println("<a href='welcomepage.html' class='button'>Home</a>");
	        
	        out.println("</body>");
	          
	        out.close();  
	        

}
}
