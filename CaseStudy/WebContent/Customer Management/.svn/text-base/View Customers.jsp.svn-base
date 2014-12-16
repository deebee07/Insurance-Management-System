<%@page import="com.model.Customer"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Reg2.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Reg1.css">
<script type="text/javascript" src="../js/validation.js"></script>
<!-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/validation.js"></script> -->
<title>View Customers</title>
</head>
<body style="background: #f0f0f0">

<div class=container>
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

<div class=wrapper>

<%
String date1=(String) request.getAttribute("date1");
String date2=(String) request.getAttribute("date2");
%>


<h1>CUSTOMERS REGISTERED FROM <%=date1 %> TO <%=date2 %></h1>


<a href="Controller?action=downloadXLS" class="btn btn--gray-dark">DOWNLOAD GENERATED XLS FILE </a>




<% 

ArrayList<Customer> customers=(ArrayList<Customer>) request.getAttribute("customerList");



if(customers.size()>0){
%>


<br>
<br>
<br>
<br>



<table id="keywords" cellspacing="0" cellpadding="0">
		<thead>
		<tr>
			<th><span>CUSTOMER ID</span></th>
			<th><span>NAME</span></th>
			<th><span>DATE OF BIRTH</span></th>
			<th><span>EMAIL</span></th>
			<th><span>ADDRESS</span></th>
			<th><span>CONTACT NUMBER</span></th>
			<th><span>PHOTO_PROOF</span></th>
			<th><span>PHOTO_PROOF_ID</span></th>
			<th><span>ADDRESS_PROOF</span></th>
			<th><span>ADDRESS_PROOF_ID</span></th>
			<th><span>CUSTOMER REGISTRATION DATE</span></th>	
		</tr>
		</thead>	


    

<% for(Customer cust:customers) { %>
		
		<tr>
			<td >  <%= cust.getCustomerId()%>   </td>
			<td ><%= cust.getCustomerName()%></td>
			<td ><%=cust.getCustomerDob()	%></td>
			<td ><%= cust.getCustomerEmail()	%></td>
			<td ><%=	cust.getCustomerAddress()%></td>
			<td ><%= cust.getCustomerContactNumber() 	%></td>
			<td ><%= cust.getPhoto_Proof() 	%></td>
			<td ><%= cust.getPhoto_Proof_Id() 	%></td>
			<td ><%= cust.getAddress_Proof() 	%></td>
			<td ><%= cust.getAddress_Proof_Id()	%></td>
			<td ><%= cust.getCustomerRegisterationDate()	%></td>
			
		</tr>
	<% }//end for %>

</table>
</div>
<a href="<%=request.getContextPath()%>/Customer Management/CustomerManagementHome.jsp"class="btn btn--gray-border" >Go to Customer Management Home</a>
<%}
else
{
%>

<h1>NO SUCH CUSTOMER FOUND</h1>



<% } %>



</div>

<div class=footer style="background-color: white; " >
Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
</div>
</body>
</html>