/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bhavin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BumbleBEE
 */
@WebServlet("/EditServelet")
public class EditServelet extends HttpServlet {

    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
     
        String sid=request.getParameter("UId");
        int id=Integer.parseInt(sid);  
          
        Student e=StudentDao.getStudentById(id);  
        response.setContentType("text/html");
       
        out.println("<link rel='stylesheet' type='text/css' href='teacher_edit.css'");
        out.println("<div>");
        out.print("<form action='EditServelet2' method='post'>"); 
         
        out.print("<tr><td></td><td><input type='hidden' name='UId' value='"+e.getUId()+"'/></td></tr>");  
        out.print("<b>Name:</b><input type='text' name='name' size='30' maxlength='20' autofocus value='"+e.getName()+"'/>"); 
        out.println("<br><br>");
        out.print("<b>Password:</b><input type='password' name='password' size='30' maxlength='20'  value='"+e.getPassword()+"'/>"); 
        out.println("<br><br>");
        out.print("<b>Cname:</b><input type='text' class='error90' name='Cname' size='30' maxlength='20' value='"+e.getCname()+"'/>"); 
        out.println("<br><br>");
        out.print("<input type='submit' value='Edit & Save '/>");  
        
        out.print("</form>");  
        out.println("</div>");
        
        out.close();
        
    }

}
