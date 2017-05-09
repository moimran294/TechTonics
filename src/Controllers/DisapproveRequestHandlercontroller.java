package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.PendingRequestDto;
import Model.PendingRequestDao;
import Model.TechTalkDao;

@SuppressWarnings("serial")
@WebServlet("/disaprovetechtalk")
public class DisapproveRequestHandlercontroller extends HttpServlet{

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String prdto4=request.getParameter("prdto4");
		try (PrintWriter pw = response.getWriter()) {
			
			pw.print("<body bgcolor='cyan'></body>");
		
			System.out.println("in disaprove contoroller  presenter"+prdto4);
			PendingRequestDao dao=new PendingRequestDao();
			int res=dao.deletePendingRequest(prdto4);
			System.out.println(res);
			
			
			
			pw.print("sorry....!!!<br> ur request could not be processed");

			response.setHeader("REFRESH", "1;url="+request.getContextPath());
			
			
	}catch (Exception e) {
		throw new ServletException("err in do-get", e);
		
	}
		
		}
}
