package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.EmployeeLogin;



public class LoginDao {
						
	
	
	private Connection connect=null;
	private PreparedStatement pst=null;
	
	private ResultSet rs=null;
	
	
public ArrayList<EmployeeLogin> allEmployeeLogin() {
		
		ArrayList<EmployeeLogin> EmployeeLogins = new ArrayList<EmployeeLogin>();
		
		try{
			connect = DBConnection.getConnection();
			

		PreparedStatement query=connect.prepareStatement("SELECT * FROM GROUPE_EMPLOYEE ");
		rs=query.executeQuery();
		
		while(rs.next()){
			EmployeeLogin tempEmp=new EmployeeLogin();
			String id=rs.getString("EMP_ID");
			String password=rs.getString("EMP_PASS");
			
			tempEmp.setEmpId(id);
			tempEmp.setEmpPassword(password);
			
			
			
			EmployeeLogins.add(tempEmp);
			}
		
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
	finally
	{
		DBConnection.closeResultSet(rs);
		DBConnection.closeStatement(pst);
		DBConnection.closeConnection(connect);
		
	}
		return EmployeeLogins;
		
	}
public String getPassword(String securityAnswer,String empId)
{  System.out.println("dao");
System.out.println(securityAnswer);System.out.println(empId);
	//ArrayList<String> passwords = new ArrayList<String>();
	PreparedStatement ps1=null;
	ResultSet rs1=null;
	String password=null;
	try
	{
		connect= DBConnection.getConnection();
		pst=connect.prepareStatement("Select security_ans from groupe_employee where emp_id=?");
		pst.setString(1,empId);
		
		rs=pst.executeQuery();
		System.out.println(rs);
		while(rs.next())
		{  String secans=rs.getString("security_ans");
		System.out.println(secans);
			if(secans.equalsIgnoreCase(securityAnswer))
			{
				System.out.println("inside if");
				ps1=connect.prepareStatement("Select emp_pass from groupe_employee where emp_Id=?");
				ps1.setString(1,empId);
				rs1=ps1.executeQuery();
				while(rs1.next())
				{
					password=rs1.getString("emp_pass");
					System.out.println(password);
			    }
			
		    }
		}
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		DBConnection.closeResultSet(rs);
		DBConnection.closeStatement(pst);
		DBConnection.closeStatement(ps1);
		DBConnection.closeConnection(connect);
		
	}
	
	return password;
	
}

}
