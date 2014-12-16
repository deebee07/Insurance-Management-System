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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Reg1.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Reg2.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/policyValidation.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validation.js"></script>
<title>Vehicle Insurance Modification</title>
</head>

<body class="bg-cyan">
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
			<font style="color: red;"> <%=request.getAttribute("msg")%></font>
		</h1>
		<%
			}

			HttpSession hsession = request.getSession(true);
			hsession.setAttribute("healthAction", "modifyVehiclePolicy");
		%>

		<form action="<%=request.getContextPath()%>/PolicyController"
			name="modifyVehiclePolicy" method="post" onsubmit="return onsubmit="
			return modifyVehicle(ID, PID, pMode, pFrequency);" class="form">
			<fieldset>
				<header>MODIFY VEHICLE INSURANCE POLICY</header>
				<section> <label class="input" for="ID"> <i
					class="icon-append icon-user"></i> <input type="text"
					placeholder="ENTER POLICY REFERENCE NUMBER:" name="ID" id="ID"
					required
					onblur="return ValidatePolicyRefNum(document.modifyVehiclePolicy.ID)">
					<b class="tooltip tooltip-bottom-right"><font color="red">Required
							Field *</font></b>
				</label> </section>

				<section> <label class="select" for="pMode"> <i
					class="icon-append icon-proof"></i> <select name="pMode" id="pMode"
					required onblur="return validatePaymentMode()">
						<option value="pMode">-------PAYMENT MODE-------</option>
						<option value="INTERNET BANKING">INTERNET BANKING</option>
						<option value="CREDIT CARD">CREDIT CARD</option>
						<option value="DEBIT CARD">DEBIT CARD</option>
				</select> <i></i> <b class="tooltip tooltip-bottom-right"><font
						color="red">Required Field *</font></b>
				</label> </section>
				<section> <label class="select" for="pFrequency">
					<i class="icon-append icon-proof"></i> <select name="pFrequency"
					id="pFrequency" required onblur="return validatePaymentFrequency()">
						<option value="pFrequency">-------PAYMENT
							FREQUENCY-------</option>
						<option value="Monthly">Monthly</option>
						<option value="Quarterly">Quarterly</option>
						<option value="HalfYearly">HalfYearly</option>
						<option value="Annually">Annually</option>
				</select> <i></i> <b class="tooltip tooltip-bottom-right"><font
						color="red">Required Field *</font></b>
				</label> </section>
				<footer> <input type="hidden" name="action"
					value="modifyVehiclePolicy"> <input type="submit"
					value="Modify" class="button"></footer>
			</fieldset>
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