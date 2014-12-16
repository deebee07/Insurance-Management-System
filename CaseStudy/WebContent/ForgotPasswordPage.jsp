
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
<title>Forgot Password Page</title>
</head>

<body class="LoginPageBody" >
<div style="background-color: orange;">
<div class=header>
<img alt="India Assurance" src="<%=request.getContextPath()%>/img/department (1).gif" align="middle" >
<% 


HttpSession session2 = request.getSession(true);
session2.setAttribute("forgotPassword","forgotPassword");

String invalid= (String) request.getAttribute("invalid");

if(invalid!=null){
	
	
%>
<center><h1><font color="red"><b> <%=invalid %></b></font></h1></center>
<%} %>

</div>



	<div id="container" >
		
		<form action="<%=request.getContextPath()%>/LoginController" name="LoginForm" method="post" onsubmit="return validate();">
		
                     <section>
						<label class="input" for="empId">
							<i class="icon-append icon-contact"></i>
							<input type="text" placeholder="Employee Id" name="empId"id="empId" required></input> 
							<b class="tooltip tooltip-bottom-right"><font color="red">*</font></b>
						</label>
					</section>
		
		
		<section>
						<label class="select" for="secqu" >
							<i class="icon-append icon-proof"></i>
							<select name="secqu" id="secqu"" required>
							  <option value="secqu">--Security Question--</option>  
			                 <option value="What is your pet's name?">What is your pet's name?</option>  
							 <option value="What is your favourite colour">What is your favourite colour?</option>
							 </select>
							<i></i>
							<b class="tooltip tooltip-bottom-right"><font color="red">*</font></b>
						</label>
					</section>
		
						 <section>
						<label class="input" for="secans">
							<i class="icon-append icon-contact"></i>
							<input type="text" placeholder="Security Answer" name="secans"id="secans" required></input> 
							<b class="tooltip tooltip-bottom-right"><font color="red">*</font></b>
						</label>
					</section>
		
		
		
		
	
		
			<div id="lower">
			
			<input type="submit" value="Submit">
			<input type=hidden value=<%request.getParameter("empId"); %> name="empId">
			</div>	
			
		</form>
	
	</div>
<% HttpSession session1 = request.getSession(true);
String empId = (String)request.getParameter("empId");
session1.setAttribute("EmpId",empId); %>
<div class=footer>
Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
</div>
</div>
</body>
</html>