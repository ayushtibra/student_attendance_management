package bhavin;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServelet2
 */
@WebServlet("/EditServelet2")
public class EditServelet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    	 
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            
            
            
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              
            String uid=request.getParameter("UId");
            int id=Integer.parseInt(uid);
            String name=request.getParameter("name");  
            String password=request.getParameter("password");  
            String Cname=(request.getParameter("Cname"));
            Student e=new Student();  
            e.setUId(id);
            e.setName(name);  
            e.setPassword(password);  
            e.setCname(Cname);
              
            System.out.println("Uid : " +e.getUId() +e.getName()+ e.getPassword()+e.getCname());
            
            int status=StudentDao.update(e);  
            if(status>0){  
                response.sendRedirect("EditDeleteStudent");  
            }else{  
                out.println("Sorry! unable to update record");  
            }  
              
            out.close();  
           
        }
        // TODO Auto-generated constructor stub
    

}
