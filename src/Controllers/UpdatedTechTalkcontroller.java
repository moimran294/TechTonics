package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.TechTalkDao;

@SuppressWarnings("serial")
@WebServlet("/Utechtalk")
public class UpdatedTechTalkcontroller extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		 HttpSession hs=request.getSession();
		try (PrintWriter pw = response.getWriter()) 
		{
			
			TechTalkDao dao=new TechTalkDao();
			System.out.println("in updated tech talk controller");
			
			
			pw.print("<body bgcolor='cyan'></body> ");
			int id1=(Integer) hs.getAttribute("usid");
			
			System.out.println(hs.getAttribute("date"));
			System.out.println("value of id"+id1);
			SimpleDateFormat sdf1=new SimpleDateFormat("YYYY-DD-MM");
			Date date1=sdf1.parse((String) hs.getAttribute("date"));
			//Date date1= sdf1.parse(request.getParameter("date"));
			java.sql.Date sql1 = new java.sql.Date(date1.getTime());
			System.out.println("value of date"+sql1);
			dao.Update(id1, sql1, request.getParameter("title"), request.getParameter("description"), request.getParameter("presenter"));
			response.setHeader("REFRESH", "1;url="+request.getContextPath());
			
			} catch (Exception e) {
				throw new ServletException("err in do-get", e);
				
			}
		
		}
	
	
}
