package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.EmployeeDto;
import Dto.TechTalkDto;
import Model.TechTalkDao;


@SuppressWarnings("serial")
@WebServlet("/summary")
public class Summarycontroller extends HttpServlet {
public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws IOException{
	rs.setContentType("text/html");
	HttpSession hs=rq.getSession();
	try(PrintWriter pw=rs.getWriter()){
		System.out.println("in summry");
		String url=rs.encodeURL("LogoutServlet");
		
		EmployeeDto u1=(EmployeeDto) hs.getAttribute("u_details");
		//RequestDispatcher rd=rq.getRequestDispatcher("summary");
		//System.out.println(u1);
		pw.print("<body background='images/my page/industrial-technology-background-9272828.jpg'></body> ");
		if(u1!=null){
			pw.print("Hello,"+u1.getName()+"<br>");
			pw.print("ur details are :"+u1);
			TechTalkDao dao=new TechTalkDao();
			ArrayList<TechTalkDto> ttlist=dao.getTechTalk();
			for(TechTalkDto ttdto:ttlist){
				pw.print("<table><tr><td>"+ttdto.getS_id()+"</td><td>"+ttdto.getTitle()+"</td><td>"+ttdto.getDate()+"</td><td>"+ttdto.getDescription()+"</td><td>"+ttdto.getPresenter()+"</td></tr></table");
			}
			
		}
		else
		{
			pw.print("client forgotton");
		}
		//if(rd!=null)
		//	rd.forward(rq, rs);
		pw.print("<br/><h3 align='right'><a href='"+url+"'>Log-Out</a></h5><h5><a href='TechTalk.jsp'>RequestTechTalk</a></h3>");
	}catch(Exception e){
		try {
			throw new ServletException("err in doget"+e);
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
}
