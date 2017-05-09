package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


import Dto.TechTalkDto;

public class TechTalkDao {

	private PreparedStatement pst1;
	private static Connection cn;
	ArrayList<TechTalkDto> dto=new ArrayList<>();
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;


	public TechTalkDao() throws Exception {
		super();
		Class.forName("com.mysql.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","123456");
		pst1 = cn.prepareStatement("select * from techtalk_details");
		pst2=cn.prepareStatement("insert into pendingrequests_details values(?,?,?,?)");
		pst3=cn.prepareStatement("insert into techtalk_details(date,title,description,presenter) values(?,?,?,?)");
		pst4=cn.prepareStatement("update techtalk_details SET date=date+? ,title=title+?,description=description+?,presenter=presenter+? where s_id=?");
	}



	public ArrayList<TechTalkDto> getTechTalk() throws Exception {
		try (ResultSet rst = pst1.executeQuery()){
			while(rst.next()){
			 dto.add(new TechTalkDto(rst.getInt(1), rst.getDate(2), rst.getString(3), rst.getString(4), rst.getString(5)));
			 System.out.println(dto);
			}
		}
		return dto;
	}
	public int addTechTalk(Date date,String title,String description,String presenter) throws Exception{
		System.out.println("in dao createEmployee");
		
		
		pst2.setDate(1, (java.sql.Date) date);
		pst2.setString(2,title);
		pst2.setString(3, description);
		pst2.setString(4, presenter);
		System.out.println("in add before execute techtalk");
		int rst=pst2.executeUpdate();
		System.out.println("in add after execute techtalk");
		if(rst==1)
		return 1;
		return 0;
	}
	
	public int AddTechTalk(Date date,String title,String description,String presenter) throws Exception{
		System.out.println("in dao createEmployee");
		
		
		pst3.setDate(1, (java.sql.Date) date);
		pst3.setString(2,title);
		pst3.setString(3, description);
		pst3.setString(4, presenter);
		System.out.println("in Add before execute techtalk");
		boolean rst=pst3.execute();
		System.out.println("in Add after execute techtalk");
		if(rst)
		return 1;
		return 0;
	}
	
	
	public int Update(int id,Date date,String title,String description,String presenter ) throws SQLException{
		
		System.out.println("in update method  ");
		int count=0;
		pst4.setInt(1, id);
		pst4.setDate(2,  (java.sql.Date) date);
		pst4.setString(3, title);
		pst4.setString(4, description);
		pst4.setString(5, presenter);
		count=pst4.executeUpdate();
			return count;	
	
}
	
	

}
