package bhavin;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		
		String n = request.getParameter("UserName");
		String p = request.getParameter("Password");
		 
		if(p.equals("admin")){
			request.getRequestDispatcher("welcomepage.html").include(request, response);
			HttpSession Session = request.getSession();
			Session.setAttribute("UserName", n);
		}
		else{
			writer.println("<h2 style='color:#98DBC6;text-align:center;margin-top:20px;'>Username or password is Wrong</h2>");
			request.getRequestDispatcher("admin.html").include(request, response);
		}
		writer.close();
		}catch(Exception ex){ex.printStackTrace();}
	}

}
