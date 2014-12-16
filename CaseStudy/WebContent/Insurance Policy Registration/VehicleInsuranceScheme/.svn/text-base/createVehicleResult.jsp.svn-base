<%@page import="com.model.Customer"%>

<%@page import="com.model.VehiclePolicy"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>

<%
	response.setHeader("Cache-Control",
			"no-store, no-cache, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", -1); //prevents caching at the proxy server

	if (request.getSession(false).getAttribute("userid") == null) {
%>

<jsp:forward page="${pageContext.request.contextPath}/../LoginPage.jsp"></jsp:forward>
<%
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Reg2.css">
<script type="text/javascript" src="js/validation.js"></script>
<title>Vehicle Registration Details</title>
</head>
<body class="container">
	<%
		HttpSession loginSession = request.getSession(true);
		String loginName = (String) loginSession.getAttribute("userid");
	%>



	<div class=header>

<img alt="India Assurance" src="<%=request.getContextPath()%>/img/department (1).gif" align="left" >
Welcome <%=loginName %>	
<a href="<%=request.getContextPath()%>/HomePage.jsp">HOME</a> |
<a href="<%=request.getContextPath()%>/LoginController">LOG OUT</a>

</div>


	<h1>Vehicle Policy Registered</h1>

	<p>
		<%
			String policyRefNumber = (request.getAttribute("polRefNum")
					.toString());
			String endDate = (request.getAttribute("endDate").toString());
		%>
	
	<h2>
		POLICY REFERENCE NUMBER GENERATED IS
		<%=policyRefNumber%></h2>
	<br>


	<br>
	<h2>
		POLICY END DATE IS
		<%=" " + endDate%></h2>
	<br>
	<br>
	<br>
	<div class=footer>
		Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
	</div>
</body>
</html>