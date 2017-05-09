package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.EmployeeDao;

@SuppressWarnings("serial")
@WebServlet("/register")
public class Registercontroller extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		 
		try (PrintWriter pw = response.getWriter()) {
			EmployeeDao dao=new EmployeeDao();
			String email = request.getParameter("email");
			String pass = request.getParameter("password");
			String name = request.getParameter("name");
			int u1=dao.createEmployee(email, pass, name);
			System.out.println("value of register u1"+u1);
			pw.print("<body bgcolor='cyan'></body> ");
			if(u1==1){
				pw.print(" registered Successfully");
				
			String url=response.encodeRedirectURL("login.jsp");
				response.sendRedirect(url);
		
			
			
			}
			else{
				pw.print(" registeration failed<br>plz retry....");
				
				pw.print("<a href='register.jsp'>TRY_AGAIN</a>");
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get", e);
		}
	
	}
}
