package bhavin;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeacherEditServlet
 */
@WebServlet("/TeacherEditServlet")
public class TeacherEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Teac_id=request.getParameter("Tid");  
        int Tid=Integer.parseInt(Teac_id);  
        
        Teacher t =  TeacherDao.getTeacherByTid(Tid);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<link rel='stylesheet' type='text/css' href='teacher_edit.css'");
        out.println("<div>");
        out.print("<form action='TeacherEditServlet2' method='post'>");  
         
        out.print("<tr><td></td><td><input type='hidden' name='Tid' value='"+t.getTid()+"'/></td></tr>");  
        out.print("<b>Name:</b><input type='text' name='name' size='30' maxlength='20' autofocus value='"+t.getName()+"'/>"); 
        out.println("<br><br>");
        out.print("<b>Password:</b><input type='password' name='password' size='30' maxlength='20'  value='"+t.getPassword()+"'/>"); 
        out.println("<br><br>");
        out.print("<b>Cname:</b><input type='text' class='error90' name='Cname' size='30' maxlength='20' value='"+t.getCname()+"'/>"); 
        out.println("<br><br>");
        out.print("<input type='submit' value='Edit & Save '/>");  
        
        out.print("</form>");  
        out.println("</div>");
        
        out.close();
    }
	

}
