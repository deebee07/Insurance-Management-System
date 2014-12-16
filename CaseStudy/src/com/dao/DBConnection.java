package com.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


		final class DBConnection {
	    private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	    private static final String URL = "jdbc:oracle:thin:@172.26.132.40:1521:orclilp";
	    private static final String USERNAME = "ja41e";
	    private static final String PASSWORD = "ja41e";
	    
	    
	public static void closeConnection(Connection con){
	try{
	if(con!=null){
	con.close();
	}
	}
	catch(Exception e){
	e.printStackTrace();
	}
	    }
	    
	public static void closeStatement(PreparedStatement pst){
	try{
	if(pst!=null){
	pst.close();
	}
	}
	catch(Exception e){
	e.printStackTrace();
	}
	    }
	
	
	public static void closeResultSet(ResultSet rs){
		try{
		if(rs!=null){
		rs.close();
		}
		}
		catch(Exception e){
		e.printStackTrace();
		}
		    }
    
	    public static Connection getConnection(){
	Connection con=null;
	try{
	Class.forName(DRIVER_NAME);
	con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	catch(Exception e){
	e.printStackTrace();
	}
	return con;
	    }
	}

