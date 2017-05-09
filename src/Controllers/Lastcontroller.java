package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.EmployeeDto;


@SuppressWarnings("serial")
@WebServlet("/LogoutServlet")
public class Lastcontroller extends HttpServlet{
	protected void doGet(HttpServletRequest rq,
			HttpServletResponse rs) throws ServletException, IOException {
		rs.setContentType("text/html");
		HttpSession hs=rq.getSession();
		
		//userDto u1= (userDto) hs.getAttribute("u_details");
		//System.out.println(u1);
		try (PrintWriter pw = rs.getWriter()) {
			EmployeeDto u1= (EmployeeDto) hs.getAttribute("u_details");
			pw.print("<body background='images/my page/537331500.jpg'></body> ");
			if (u1 != null) 
				pw.print("Cookie based User details from Logout page" + u1);
				else
				{
				pw.print("Clnt forgotten....");
				}
			//pw.print("<h5><a href='index.html'>VISIT_AGAIN</a></h5>");
			rs.setHeader("REFRESH", "1;url="+rq.getContextPath());
			//rs.sendRedirect("index.html");
		}
	}
}
