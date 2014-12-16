
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/animate.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">



<script type="text/javascript" src="./js/validation.js"></script>
<title>Homepage of the Web project</title>
</head>

<body  class="LoginPageBody"  >  <!--  class="LoginPageBody" background="<%=request.getContextPath()%>/img/insurancebg.jpg" -->

<div class=header>
<img alt="India Assurance" src="<%=request.getContextPath()%>/img/department (1).gif" align="middle" >
<% 

if(request.getAttribute("msg")!=null)
{
	out.print(request.getAttribute("msg"));
}
String invalid= (String) request.getAttribute("invalid");


if(invalid!=null){
	
	
%>
<center><h1><font color="red"><b> <%=invalid %></b></font></h1></center>
<%} %>

</div>



	<div id="container" >
		
		<form action="<%=request.getContextPath()%>/LoginController" name="LoginForm" method="post" onsubmit="return validate();">
		
		<label for="name">EMPLOYEE ID<font color="red"><b> *</b></font></label>
		
		<input type="name" name="name" id ="name">
		
		<label for="password">PASSWORD<font color="red"><b> *</b></font></label>
		
		<input type="password" name="password" id ="password" >
		
		<a href="ForgotPasswordPage.jsp">Forgot Password?</a>
		<!-- <input type=button value="Forgot Password?" name="ForgotPasswordPage.jsp"/> -->
		
		
			<div id="lower">
			
			<input type="submit" value="Login">
			</div>	
		</form>
	
	</div>
<%HttpSession session1 = request.getSession(true);
String empId = (String)request.getParameter("name");
session1.setAttribute("EmpId",empId);
				%>
<div class=footer>
Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
</div>
</div>
</body>
</html>