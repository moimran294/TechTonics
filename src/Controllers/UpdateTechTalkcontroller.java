package Controllers;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






@SuppressWarnings("serial")
@WebServlet("/updatetechtalk")
public class UpdateTechTalkcontroller extends HttpServlet{

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		 HttpSession hs=request.getSession();
		try (PrintWriter pw = response.getWriter()) 
		{
			
			String dto1=request.getParameter("ttdto1");
			String dto2=request.getParameter("ttdto2");
			String dto3=request.getParameter("ttdto3");
			String dto4=request.getParameter("ttdto4");
			System.out.println(request.getParameter("ttdto5"));
			int dto5=Integer.parseInt(request.getParameter("ttdto5"));
			System.out.println(" in update techtalk controller");
			hs.setAttribute("usid", dto5);
			hs.setAttribute("date", dto1);
			System.out.println("value of sid "+dto5);
			request.setAttribute("date", dto1);
			request.setAttribute("title", dto2);
			request.setAttribute("description", dto3);
			request.setAttribute("presenter", dto4);
			request.getRequestDispatcher("UTechTalk.jsp").forward(request,response);
			
			
			
			
			
			
			
			} catch (Exception e) {
				throw new ServletException("err in do-get", e);
				
			}
		
		}
	
	
}
