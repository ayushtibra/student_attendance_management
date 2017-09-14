package bhavin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/TeacherSaveServlet")
public class TeacherSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		//System.out.println("SaveServletRunning");
		PrintWriter writer = response.getWriter();
		
		String Teac_name = request.getParameter("name");
		String Teac_pass = request.getParameter("password");
		String Teac_course = request.getParameter("Cname");
		
	//	System.out.println(Teac_course+Teac_name+Teac_pass);
		
		Teacher t = new Teacher();
		t.setTid(TeacherDao.IdGenerator());
		t.setName(Teac_name);
		t.setPassword(Teac_pass);
		t.setCname(Teac_course);
		
		
		int status = TeacherDao.save(t);
		//System.out.println("status"+status);
		if(status > 0){
		//	writer.println("<p>Record Saved Successfully</p>");
			request.getRequestDispatcher("add_teacher1.html").include(request, response);
		}else{
			writer.println("<p>Sorry ! Record Cannot be Saved</p>");
			request.getRequestDispatcher("add_teacher.html").include(request, response);
		}
		
		writer.close();
		
	}

}

