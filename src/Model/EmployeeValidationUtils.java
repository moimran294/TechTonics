package Model;


public class EmployeeValidationUtils {

	
	public static int MINLENGTH;
	public static int MAXLENGTH;
	public static String a;
	
	static
	{
		
		a="@atmecs.com";
		MINLENGTH=5;
		MAXLENGTH=9;
	}
	
	
	public  boolean validateEmail(String email) 
	{
		if(!email.contains(a))
			return false;
		return true;
	}
	public  boolean validatePassword(int pass) 
	{
		if(pass<MINLENGTH || pass>MAXLENGTH)
			return false;
		return true;
	}
	
	
}
