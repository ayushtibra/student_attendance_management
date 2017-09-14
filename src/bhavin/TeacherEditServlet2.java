package bhavin;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherEditServlet2")
public class TeacherEditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter writer=response.getWriter();  
	          
	        String Teac_id=request.getParameter("Tid");  
	        int Tid=Integer.parseInt(Teac_id);  
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        String Teac_cname=request.getParameter("Cname");  
	          
	          
	        Teacher t = new Teacher();
	        
	        t.setTid(Tid);
	        t.setName(name);
	        t.setPassword(password);
	        t.setCname(Teac_cname);
	        
	        
	        int status=TeacherDao.update(t);  
	        if(status>0){  
	            response.sendRedirect("EditDeleteTeacher");  
	        }else{  
	            writer.println("Sorry! unable to update record");  
	        }  
	          
	        writer.close();  
		
		
	}

}

