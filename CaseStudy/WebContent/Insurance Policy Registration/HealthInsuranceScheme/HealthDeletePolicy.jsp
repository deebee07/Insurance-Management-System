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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/animate.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/styles.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/policyValidation.js"></script>
<script type="text/javascript" src="../../js/validation
		.js"></script>
</head>

<body>
	<%
		HttpSession loginSession = request.getSession(true);
		String loginName = (String) loginSession.getAttribute("userid");
	%>



	<div class=header>

		<img alt="India Assurance"
			src="<%=request.getContextPath()%>/img/department (1).gif"
			align="left"> Welcome
		<%=loginName%>
		<a href="<%=request.getContextPath()%>/HomePage.jsp">HOME</a> | <a
			href="<%=request.getContextPath()%>/LoginController">LOG OUT</a>

	</div>


	<div class="body body-s">
		<%
			if (request.getAttribute("msg") != null) {
		%>

		<h1>
			<center>
				<font style="color: red;"> <%=request.getAttribute("msg")%></font>
			</center>
		</h1>
		<%
			}

			HttpSession hsession = request.getSession(true);
			hsession.setAttribute("healthAction", "deleteHealthPolicy");
		%>
		<center>
			<h1>DELETE HEALTH INSURANCE POLICY</h1>
		</center>
		<div id="container" style="height: 150px;">

			<form action="<%=request.getContextPath()%>/PolicyController"
				name="deleteHealthPolicy" method="post"
				onsubmit="return deleteHealthUsingPolicyRefNum(PID)">


				<label for="PID">ENTER POLICY REFERENCE #<font color="red"><b>
							*</b></font></label> <input type="name" name="PID" id="PID"
					onblur="return ValidatePolicyRefNum(document.deleteHealthPolicy.PID)">


				<div id="lower">
					<input type="hidden" name="action" value="deleteHealthPolicy">
					<input type="submit" value="Delete"></input>
				</div>
			</form>
		</div>


		<div class=footer>
			<p>
				Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
			</p>
		</div>


	</div>

</body>
</html>