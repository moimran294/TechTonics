package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dto.EmployeeDto;


public class EmployeeDao {

	private static Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	EmployeeValidationUtils util;
	public EmployeeDao() throws Exception{
		super();
		
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","123456");
		util=new EmployeeValidationUtils();
		pst1 = cn.prepareStatement("select * from Employee_details where email = ? and password=?");
		pst2=cn.prepareStatement("insert into Employee_details values(?,?,?)");
		
	}
	
	
	
	// clean up
		public void cleanUp() throws Exception {
			if (pst1 != null)
				pst1.close();
			if (cn != null)
				cn.close();
			System.out.println("dao cleaned up");
		}
		
		
		// CRUD
		public EmployeeDto validateEmployee(String name,String pass) throws Exception {
			
			System.out.println("in dao validate employee");
			if(util.validateEmail(name));
			int passlen=pass.length();
			if(util.validatePassword(passlen));
			pst1.setString(1, name);
			pst1.setString(2, pass);
			try (ResultSet rst = pst1.executeQuery()) {
				
				if(rst.next())
				return new EmployeeDto(rst.getString(1), rst.getString(2), rst.getString(3));
			}
			return null;
		}	
		
		public int createEmployee(String email,String password,String name) throws Exception{
			System.out.println("in dao createEmployee");
			
			int passlen=password.length();
			if(util.validatePassword(passlen) && util.validateEmail(email)){
			pst2.setString(1, email);
			pst2.setString(2, password);
			pst2.setString(3, name);
			int rst=pst2.executeUpdate();
			System.out.println(rst);
			return rst;
			}
			else return 0;
		}
		
		
}
