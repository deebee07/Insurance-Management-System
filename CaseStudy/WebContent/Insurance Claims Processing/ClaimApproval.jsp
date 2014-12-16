<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	
	<% if(request.getAttribute("msg")!=null)
		{
		   out.println("<h1><b><font color='red'>Claim Approved</font></b></h1>");
		  
		  
 	}
	else
	{
	
	
		    HttpSession hsession = request.getSession(true);
		    hsession.setAttribute("claimAction", "approveClaim");

				ClaimProcessing cp = (ClaimProcessing) request.getAttribute("claimProcessing");
			
			    HttpSession claimProcessingSession=request.getSession(true);
			    claimProcessingSession.setAttribute("claimSession", cp);
			    
			    String claimId=(String) request.getAttribute("claimId");
			    
			    HttpSession claimIdSession=request.getSession(true);
			    claimIdSession.setAttribute("claimIdSession", claimId);
			%>
	
	
	
	
	
	

		<form action="<%=request.getContextPath()%>/ClaimController" name="ClaimDetails" method="post" onsubmit="return validate();"class="form">
			
			<fieldset>
		    <header>Approve or Reject Claim</header>
				
			
		
						
			<section>		
			<label for="n1" class="input"><b>Claim Amount</b></label>
			<input type="text" name="n1" id ="n1" value="<%=cp.getClaimAmount()%>" readonly="readonly" >
		
			</section>
			
			<section>
			<label for="n2"class="input"><b>Claim Submission Date</b></label>
			<input type="text" name="n2" id ="n2" value="<%=cp.getClaimSubmissionDate()%>" readonly="readonly">
			</section>
			
			<section>
			<label for="n3"class="input"><b>Beneficiary Name</b></label>
			<input type="text" name="n3" id ="n3" value="<%=cp.getBenName()%>"readonly="readonly">
			</section>
			
			<section>
			<label for="n4"class="input"><b>Beneficiary Address</b></label>
			<input type="text" name="n4" id ="n4" value="<%=cp.getBenAddress()%>"readonly="readonly">
			</section>
			
			<section>
			<label for="n5"class="input"><b>Beneficiary Email</b></label>
			<input type="text" name="n5" id ="n5" value="<%=cp.getBenEmail()%>"readonly="readonly">
			</section>
			
			<section>
			<label for="n6"class="input"><b>Beneficiary Contact</b></label>
			<input type="text" name="n6" id ="n6" value="<%=cp.getBenContactNo()%>"readonly="readonly">
			</section>
			
			<section>
			<label for="n7"class="input"><b>Beneficiary Age</b></label>		
			<input type="text" name="n7" id ="n7" value="<%=cp.getBenAge()%>"readonly="readonly">
			</section>
			<input type="hidden" name="hiddenClaimId" value=<%=claimId%>></input>					
		
				<footer>
					<input type="submit" value="APPROVE"class="button"> </input>
					<a href="<%=request.getContextPath()%>/Insurance Claims Processing/ClaimRejection.jsp" class="button">REJECT</a>
				</form>
				</footer>
				</fieldset>
				
				
			
			
		</div>
					
			
		
			
	
<%
}
%>

<div class=footer>
		Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
	</div>
</body>
</html>