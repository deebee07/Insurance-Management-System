<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
    
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

<title>Admin Home</title>
</head>
<body>


<%
HttpSession hsession = request.getSession(true);
hsession.setAttribute("claimAction", "ClaimDetails"); 
HttpSession loginSession = request.getSession(true);
String loginName=(String)loginSession.getAttribute("userid");

%>

<div class=header>

<img alt="India Assurance" src="<%=request.getContextPath()%>/img/department (1).gif" align="left" >
Welcome <%=loginName %>	

<a href="<%=request.getContextPath()%>/LoginController">LOG OUT</a>

</div>


<center><h1><b>Admin Home Page</b></h1></center>
<br/>
<br/>
<br/>

<% if(request.getAttribute("msg")!=null)
{
	out.print("<h1>" +  request.getAttribute("msg") + "</h1>");
} %>

<div id="container" style="height: 200px;">
		
<a href="/Updates/">Add Employee</a>
		
		<form  action="<%=request.getContextPath()%>/ClaimController" name="getClaimDetails" method="post" onsubmit="return validate();">
		
		
			<label for="claimId">ENTER THE CLAIM ID:<font color="red"><b> *</b></font></label> 
		
			<input type="name" name="claimId" id ="claimId">
		
		
			<div id="lower">
		
			<input type="submit" value="Submit"></input>
			</div>	
			
			
		</form>
		
		</div>
	
	
<div class=footer>
Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
</div>
</body>
</html>