<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

	<br></br>
	<br>
	<br>
	<br>
	<br>
	<br>








	<h1>
		Sorry!!! No Authority
		<h1>
			<br>
			<div class=footer>
				Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
			</div>
</body>
</html>