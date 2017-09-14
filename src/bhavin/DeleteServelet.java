package bhavin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BumbleBEE
 */
@WebServlet("/DeleteServelet")
public class DeleteServelet extends HttpServlet {


   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */


	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String sid=request.getParameter("UId");  
        int id=Integer.parseInt(sid);  
          
   
        StudentDao.delete(id);
        response.sendRedirect("EditDeleteStudent");  
        
    }

}