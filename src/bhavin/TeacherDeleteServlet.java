package bhavin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherDeleteServlet")
public class TeacherDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        String Tid=request.getParameter("Tid");  
		        int id=Integer.parseInt(Tid);  
		        TeacherDao.delete(id);  
		        response.sendRedirect("EditDeleteTeacher");  
		    } 
		
		
	}
