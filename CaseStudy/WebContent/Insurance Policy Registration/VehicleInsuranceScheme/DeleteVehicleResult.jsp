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

<div class="container">
	<h1>
		POLICY IS DELETED
		<h1>
			<br><br><br>
			<div class=footer>
				Copyright � 2014 <a href="#">newindiaassurance@ltd</a>
			</div>
</body>
</html>