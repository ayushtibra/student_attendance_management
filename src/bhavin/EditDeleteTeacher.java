

package bhavin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditDeleteTeacher")
public class EditDeleteTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		  writer.println("<link rel='stylesheet' type='text/css' href='editdeleteteacher.css'>");
		  writer.println("<body>");
		   
	      writer.println("<h1>Teacher List</h1>");
	        
	      List<Teacher> list = TeacherDao.getAllTeacher();
	      
	      writer.print("<table id='customers'>");  
	      writer.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Course</th><th>Edit</th><th>Delete</th></tr>");  
	      
	      for(Teacher t:list){
	    	  writer.print("<tr><td>"+t.getTid()+"</td><td>"+t.getName()+"</td><td>"+t.getPassword()+"</td><td>"+t.getCname()+"</td><td><a href='TeacherEditServlet?Tid="+t.getTid()+"'>edit</a></td>  <td><a href='TeacherDeleteServlet?Tid="+t.getTid()+"'>delete</a></td></tr>");  
	      }
	       
	      writer.println("</table>");
	      writer.println("<a href='add_teacher.html' class='button'>Add New Teacher</a>");
	      writer.println("<a href='welcomepage.html' class='button'>Home</a>");
	      
	      writer.println("</body>");
		writer.close();
	}

}