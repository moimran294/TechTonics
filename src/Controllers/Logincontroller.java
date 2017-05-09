package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.EmployeeDto;
import Model.EmployeeDao;




@WebServlet("/Login")
public class Logincontroller extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		 HttpSession hs=request.getSession();
		try (PrintWriter pw = response.getWriter()) {
			EmployeeDao dao=new EmployeeDao();
			String name = request.getParameter("email");
			String pass = request.getParameter("password");
			EmployeeDto u1=dao.validateEmployee(name,pass);
			pw.print("<body background='images/my page/icona-differente-di-tecnologia-e-del-social-27723841.jpg'></body> ");
			if(u1!=null){
				pw.print("Logged in Successfully");
				
			String url=response.encodeRedirectURL("summary");
				response.sendRedirect(url);
		
			hs.setAttribute("u_details", u1);
			
			}
			else{
				pw.print("Log in failed<br>plz retry....");
				
				pw.print("<a href='login.jsp'>TRY_AGAIN</a>");
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get", e);
		}
	
	}

}
