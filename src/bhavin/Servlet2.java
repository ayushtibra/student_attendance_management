package bhavin;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			 response.setContentType("text/html");  
	            PrintWriter out=response.getWriter();  
	               
	              
	            HttpSession session=request.getSession();  
	            session.invalidate();  
	              
	            request.getRequestDispatcher("main.html").include(request, response); 
	              
	            out.close();  
			}catch(Exception ex){ex.printStackTrace();}
		
		
		
	}

}
