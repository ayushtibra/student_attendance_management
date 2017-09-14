package bhavin;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServelet
 */
@WebServlet("/SaveServelet")
public class SaveServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int id = -2;
    /**
     * @see HttpServlet#HttpServlet()
     */
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
	    
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();
	                
	       
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        String Cname=(request.getParameter("Cname"));
	          
	        Student e=new Student(); 
	        e.setUId(StudentDao.IdGenerator());
	        e.setName(name);  
	        e.setPassword(password); 
	        e.setCname(Cname);
	  
	          
	        int status=StudentDao.save(e);  
	        if(status>0){  
	             
	            request.getRequestDispatcher("add_student1.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();
	          
	    }
	   
}
