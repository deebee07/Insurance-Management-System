<%@page import="com.model.Customer"%>
<%@page import="com.model.VehiclePolicy"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Reg1.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validation.js"></script>
<title>View Customers</title>
</head>
<body class="bg-cyan">
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

	<div class=content>
		<%
			ArrayList<VehiclePolicy> displayList = (ArrayList<VehiclePolicy>) request
					.getAttribute("viewVehiclePolicyList");

			if (displayList.size() > 0) {
		%><br> <br>
		<table id="keywords">
			<thead>
				<tr>
					<th>CUSTOMER ID</th>
					<th>POLICY REFERENCE NUMBER</th>
					<th>POLICY ID</th>
					<th>POLICY COMMENCEMENT DATE</th>
					<th>POLICY END DATE</th>
					<th>PAYMENT MODE</th>
					<th>PAYMENT FREQUENCY</th>
					<th>PREMIUM AMOUNT</th>
					<th>VEHICLE NUMBER</th>
					<th>LICENCE NUMBER</th>
					<th>VEHICLE TYPE</th>

				</tr>
			</thead>

			<%
				for (VehiclePolicy vp : displayList) {
			%>

			<tr>
				<td><%=vp.getCustomerId()%></td>
				<td><%=vp.getPolicyRefNum()%></td>
				<td><%=vp.getPolicyId()%></td>
				<td><%=vp.getPolicyCommDate()%></td>
				<td><%=vp.getPolicyEndDate()%></td>
				<td><%=vp.getPaymentMode()%></td>
				<td><%=vp.getPaymentFreq()%></td>
				<td><%=vp.getPremiumAmount()%></td>
				<td><%=vp.getVehicleNum()%></td>
				<td><%=vp.getLicenseNum()%></td>
				<td><%=vp.getVehicleType()%></td>

			</tr>
			<%
				}//end for
			%>
		</table>

		<%
			}//end if 
			else {
		%>
		<table>
			<tr>
				<td>NO POLICY IN DATABASE</td>
			</tr>
		</table>

		<%
			}
		%>
		
	</div>

	<div class=footer>
		Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
	</div>


	</div>




</body>
</html>
