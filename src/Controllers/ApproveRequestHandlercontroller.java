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

import Dto.PendingRequestDto;
import Model.PendingRequestDao;
import Model.TechTalkDao;

@SuppressWarnings("serial")
@WebServlet("/aprovetechtalk")
public class ApproveRequestHandlercontroller  extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");
	 HttpSession hs=request.getSession();
	try (PrintWriter pw = response.getWriter()) {
		
		String prdto1=request.getParameter("prdto1");
		String prdto2=request.getParameter("prdto2");
		String prdto3=request.getParameter("prdto3");
		String prdto4=request.getParameter("prdto4");
		
		System.out.println(" in update techtalk controller");
		
		
		SimpleDateFormat sdf1=new SimpleDateFormat("YYYY-DD-MM");
		Date date1= sdf1.parse(prdto1);
		java.sql.Date sql1 = new java.sql.Date(date1.getTime());
		System.out.println("value of date"+sql1);
		
		
		System.out.println("presenter in approve"+prdto4);
		pw.print("<body bgcolor='cyan'></body>");
	
		System.out.println("in pending request handler aprove ");
		PendingRequestDao dao=new PendingRequestDao();
		int res=dao.deletePendingRequest(prdto4);
		System.out.println(res);
		TechTalkDao daoo=new TechTalkDao();
		int rst=daoo.addTechTalk(sql1,prdto2,prdto3, prdto4);
		System.out.println(rst);
		if(rst==1){
		pw.print(" approved successfully");}

		response.setHeader("REFRESH", "1;url="+request.getContextPath());
		
		
}catch (Exception e) {
	throw new ServletException("err in do-get", e);
	
}
	
	}
}