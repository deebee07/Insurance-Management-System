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
			hsession.setAttribute("healthAction", "registerHealthPolicy");
		%>


		<form action="<%=request.getContextPath()%>/PolicyController"
			name="registerHealthPolicy" method="post"
			onsubmit="return validatePolicyRegistration()" class="form">



			<fieldset>
				<header> Health Insurance Policy Registration form</header>
				<section> <label class="input" for="id"> <i
					class="icon-append icon-user"></i> <input type="text"
					placeholder="ENTER CUSTOMER ID:" name="id" id="ID" required
					onblur="return validateNum(document.registerHealthPolicy.id)">
					<b class="tooltip tooltip-bottom-right"><font color="red">Required
							Field *</font></b>
				</label> </section>

				<section> <label class="input" for="PID"> <i
					class="icon-append icon-pid"></i> <input type="text"
					placeholder="ENTER POLICY ID:" name="pid" id="PID" required
					onblur="return validateNum(document.registerHealthPolicy.pid)">
					<b class="tooltip tooltip-bottom-right"><font color="red">Required
							Field *</font></b>

				</label> </section>

				<section> <label class="input" for="tenure"> <i
					class="icon-append icon-"></i> <input type="text"
					placeholder="POLICY TENURE:" name="tenure" id="tenure" required
					onblur="return validateNum(document.registerHealthPolicy.tenure)">
					<b class="tooltip tooltip-bottom-right"><font color="red">Required
							Field *</font></b>
				</label> </section>

				<section> <label class="input" for="cDate"> <i
					class="icon-append icon-dob"></i> <input type="text"
					placeholder="POLICY COMMENCEMENT DATE: dd/mm/yyyy" name="cDate"
					id="cDate" required
					onblur="return  validateDatePolicy(document.registerHealthPolicy.cDate)">
					<b class="tooltip tooltip-bottom-right"><font color="red">Required
							Field *</font></b>

				</label> </section>

				<section> <label class="input" for="eDate"> <i
					class="icon-append icon-dob"></i> <input type="text"
					placeholder="POLICY END DATE: dd/mm/yyyy" name="eDate" id="eDate"
					required onblur="return validateEndDatePolicy(document.registerHealthPolicy.eDate)"> <b
					class="tooltip tooltip-bottom-right"><font color="red">Required
							Field *</font></b>
				</label> </section>

				<section> <label class="select" for="pMode"> <i
					class="icon-append icon-proof"></i> <select name="pMode" id="pMode"
					required onblur="return validatePaymentMode()">
						<option value="pMode">---PAYMENT MODE---</option>
						<option value="INTERNET BANKING">INTERNET BANKING</option>
						<option value="CREDIT CARD">CREDIT CARD</option>
						<option value="DEBIT CARD">DEBIT CARD</option>
				</select> <i></i> <b class="tooltip tooltip-bottom-right"><font
						color="red">Required Field *</font></b>
				</label> </section>

				<section> <label class="select" for="pFrequency">
					<i class="icon-append icon-proof"></i> <select name="pFrequency"
					id="pFrequency" required onblur="return validatePaymentFrequency()">
						<option value="pFrequency">---PAYMENT FREQUENCY---</option>
						<option value="Monthly">Monthly</option>
						<option value="Quarterly">Quarterly</option>
						<option value="HalfYearly">HalfYearly</option>
						<option value="Annually">Annually</option>
				</select> <i></i> <b class="tooltip tooltip-bottom-right"><font
						color="red">Required Field *</font></b>
				</label> </section>

				<section> <label class="input" for="pAmount"> <i
					class="icon-append icon-rupee"></i> <input type="text"
					placeholder="PREMIUM AMOUNT:" name="pAmount" id="pAmount" required
					onblur="return validateNum(document.registerHealthPolicy.pAmount)">
					<b class="tooltip tooltip-bottom-right"><font color="red">Required
							Field *</font></b>
				</label> </section>


				<footer> <input type="hidden" name="action"
					value="registerHealthPolicy"> <input type="submit"
					value="Register" class="button"></footer>
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