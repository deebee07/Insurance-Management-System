package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.EmployeeLogin;
import com.util.Service;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Service service= new Service();
		ArrayList<EmployeeLogin> Logins=service.allEmployeeLogIn();
		String logIn= 	request.getParameter("name");
		
		System.out.println(logIn);
		String Password=request.getParameter("password");
		System.out.println(Password);
		
				
		request.setAttribute("EmpId", logIn);
		
		
		System.out.println("before for");
		
		for(EmployeeLogin emp:Logins)
		{ System.out.println("in for");
			if(emp.getEmpId().equals(logIn)	&&	emp.getEmpPassword().equals(Password))
			{ System.out.println("in if");
				
			    RequestDispatcher reqDispatcher=request.getRequestDispatcher("/HomePage.jsp");
				HttpSession loginSession = request.getSession(true);
				loginSession.setAttribute("userid",logIn);
				
				reqDispatcher.forward(request, response);
				return;
			}
				
				
		}
		
		HttpSession session = request.getSession(true);
		String action = (String) session.getAttribute("forgotPassword");
		if("forgotPassword".equals(action))
		{   
			HttpSession session1 = request.getSession(true);
			String empId = (String) session1.getAttribute("EmpId");
			String empId1=request.getParameter("empId");
			String securityAnswer=request.getParameter("secans");
			
			String password = service.getPassword(securityAnswer,empId1);
			System.out.println(password);
			
			RequestDispatcher rd=request.getRequestDispatcher("/LoginPage.jsp");
			request.setAttribute("msg", "<h1><font color='red'>Your password is "+password+"</font></h1>");
			rd.forward(request, response);
			
			
		}
		
		else if(logIn.equals("admin")&&Password.equals("adminpass"))
		{
			RequestDispatcher reqDispatcher=request.getRequestDispatcher("/Admin_HomePage.jsp");
			HttpSession loginSession = request.getSession(true);
			loginSession.setAttribute("userid",logIn);
			reqDispatcher.forward(request, response);
			
		}
		else 
		{
			RequestDispatcher reqDispatcher=request.getRequestDispatcher("/LoginPage.jsp");
			request.setAttribute("invalid","Invalid Login credentials");
			reqDispatcher.forward(request, response);
			
		}
	
		
		
		
		
		
	}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	  
	
	System.out.println("get");
	HttpSession loginSession = req.getSession(true);

	loginSession.setAttribute("userid",null);
	loginSession.invalidate();
	
	
	response.sendRedirect(req.getContextPath() + "/LoginPage.jsp");
	
}



}
