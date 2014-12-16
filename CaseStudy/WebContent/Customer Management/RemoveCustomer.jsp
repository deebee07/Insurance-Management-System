<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% response.setHeader( "Cache-Control", "no-store, no-cache, must-revalidate");  //HTTP 1.1
         response.setHeader("Pragma","no-cache"); //HTTP 1.0
         response.setDateHeader ("Expires", -1); //prevents caching at the proxy server
         
         if(request.getSession(false).getAttribute("userid")==null)
         {
        %>
        
        <jsp:forward page="${pageContext.request.contextPath}/../LoginPage.jsp"></jsp:forward>
        <% 
         }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/animate.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Reg2.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validation.js"></script>
<title>Delete Customer</title>
</head>

<body>

<% 

HttpSession loginSession = request.getSession(true);
String loginName=(String)loginSession.getAttribute("userid");


%>

	

<div class=header>

<img alt="India Assurance" src="<%=request.getContextPath()%>/img/department (1).gif" align="left" >
Welcome <%=loginName %>	
<a href="<%=request.getContextPath()%>/HomePage.jsp">HOME</a> |
<a href="<%=request.getContextPath()%>/LoginController">LOG OUT</a>

</div>

<% 
String invalid= (String) request.getAttribute("invalid");

if(invalid!=null){
%>
<center><h1><font color="red"><b> <%=invalid %></b></font></h1></center>
<%} %>
<br>
<br>
<br>


	<div id="container" style="height: 200px;">
		
		<form  action="<%=request.getContextPath()%>/Controller" name="deleteCustomer" method="post" onsubmit="return validateNum(document.deleteCustomer.customerId)">
		
		
			<label for="customerId">ENTER THE CUSTOMER ID TO BE DELETED<font color="red"><b> *</b></font></label> 
		
			<input type="name" name="customerId" id ="customerId">
		
		
			<div id="lower">
			<input type="submit" value="Remove"></input>
			</div>	
		</form>
		</div>



<% 
HttpSession sessionn = request.getSession(true);
sessionn.setAttribute("custAction", "removeCustomer");
%>

<div class=footer>
Copyright � 2014 <a href="#">newindiaassurance@ltd</a>
</div>



</body>
</html>