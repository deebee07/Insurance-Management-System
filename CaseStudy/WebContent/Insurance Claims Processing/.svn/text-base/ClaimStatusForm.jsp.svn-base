<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ page import="com.model.ClaimProcessing" session="true"%>
    
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Reg1.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Reg2.css">


<title>Rejection Page</title>
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
<div class="body body-s" max-width: 400px; >
	
	
	
	
	
		   <% 

				ClaimProcessing cp = (ClaimProcessing) request.getAttribute("claimProcessing");
			
			  
			    
			    String claimId=(String)request.getAttribute("claimId");
			    
			    HttpSession claimIdSession=request.getSession(true);
			    claimIdSession.setAttribute("claimIdSession", claimId);
			    
			%>
	
	

		<form action="<%=request.getContextPath()%>/ClaimController" name="ClaimDetails" method="post" onsubmit="return validate();"class="form">
			
			<fieldset>
		    <header>CLAIM STATUS </header>
				
			<section>		
			
			<label for="n1" style="font-size:xx-large;"><b><%=cp.getClaimStatus()%></b></label>
			
			</section>
			
			<% if(cp.getRejReason()!=null)
				
			{
				 String[] s=cp.getRejReason().split(",");
				%>
				<table id="keywords">
				<tr>
				
				<th><b>Reasons:</b></th>
			    </tr>
				
				
				 <%
				  
				   for(String str:s)
				   {
					   %>
					   <tr>
					   <td><%=str %></td>
					   </tr>
					   
				 <%  } %> 
				  
				   
				    
				</tr>
				</table>
			
			</form>
		</fieldset>
				
 <%
}
%>

</div> 




<div class=footer style="height:70px" >
		Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
	</div>
</body>
</html>