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

<title>Approval/Rejection Page</title>
</head>
<body class="bg-cyan">
	<% 

HttpSession loginSession = request.getSession(true);
String loginName=(String)loginSession.getAttribute("userid");


%>

	

<div class=header>

<img alt="India Assurance" src="<%=request.getContextPath()%>/img/department (1).gif" align="left" >
Welcome <%=loginName %>	
<a href="<%=request.getContextPath()%>/Admin_HomePage.jsp">ADMIN HOME</a> |
<a href="<%=request.getContextPath()%>/LoginController">LOG OUT</a>

</div>

<div class="body body-s" >
	
<% 
if(request.getAttribute("msgrej")!=null)
{
	 out.println(request.getAttribute("msgrej"));
}
else
{
	 	
	if(request.getAttribute("msg")!=null)
	{
	   out.println(request.getAttribute("msg"));
	  
	   
 	}
	 	
	
   HttpSession hsession = request.getSession(true);
   hsession.setAttribute("claimAction", "rejectClaim");
   
   HttpSession claimProcessingSession=request.getSession(true);
   ClaimProcessing cp=(ClaimProcessing)claimProcessingSession.getAttribute("claimSession");
   
   HttpSession claimIdSession=request.getSession(true);
   String claimId=(String)claimIdSession.getAttribute("claimIdSession");
   
%>











<form action="<%=request.getContextPath()%>/ClaimController" name="ClaimDetails" method="post" onsubmit="return validate();" class="form">
			
			<fieldset>
		    <header>Reject Claim Id <%=claimId %></header>
				
			
			 <input type="hidden" name="hiddenClaimId" value=<%=claimId%>></input>					
		
		    <table id="keywords">
		     <tr>
		    <td><input type="checkbox" name="reason" value="Policy is inactive"></input></td> <td> Policy is inactive </td> 
		     </tr>
		      <tr>
		     <td><input type="checkbox" name="reason" value=" Claim amount exceeds maximum limit"></input></td> <td> Claim amount exceeds maximum limit </td>
		     </tr>
		     <tr>
		   <td><input type="checkbox" name="reason" value=" Submission date is not within policy tenure"></td>  <td> Submission date is not within policy tenure</td> 
		     </tr>
		     <tr>
		    <td><input type="checkbox" name="reason" value=" Beneficiary is a minor"></input></td>  <td> Beneficiary is a minor </td>
		     </tr>
		     </table>
		    
		   
		
				<footer>
					<input type="submit" value="REJECT" class="button"> </input>
					
					
					
					
				</form>
				</footer>
				</fieldset>
				
				
			
			
			
			
	
	<%} %>	
	</div>
						
	<div class=footer>
		Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
	</div>
	
</body>
</html>