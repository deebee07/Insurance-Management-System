<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.model.Customer"   session="true"%>
    
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
<title>CLAIM REGISTRATION</title>		
		
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validation.js"></script>
<title>CLAIM REGISTRATION</title>
</head>

<body class="bg-cyan">
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
	
		<div class="body body-s" >
		

	<%  Customer customer=(Customer)request.getAttribute("msg1");
      HttpSession hsession = request.getSession(true);
      hsession.setAttribute("claimAction", "claimRegistration");
      %>
	 
     
<form  action="<%=request.getContextPath()%>/ClaimController" name="claimForm" method="post"  
onsubmit="return validateClaimRegistration(document.claimForm.ID,document.claimForm.PRNum,document.claimForm.cAmount,document.claimForm.cDate,document.claimForm.bName,document.claimForm.bAddr,document.claimForm.bEmail,document.claimForm.bNum,document.claimForm.bAge)"  
class="form">
			<fieldset>
			  <input type="hidden" value=<%=customer.getCustomerId() %> name="hiddenCustId"></input>
				<header>Claim Registration form for Customer ID : <%=customer.getCustomerId() %></header>
				
				<br/>
				<br/>
				
				<h1><b><%=customer.getCustomerName() %></b></h1>
				<br/>
				<br/>
				<br/>
					
					
					
					
		
		            <section>
						<label class="input" for="cAmount">
							<i class="icon-append icon-rupee"></i>
							<input type="text" placeholder="CLAIM AMOUNT:" name="cAmount" id ="cAmount" onblur="return validateNum(document.claimForm.cAmount)" >
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
		
		
				<section>
						<label class="input" for="cDate">
							<i class="icon-append icon-dob"></i>
							<input type="text" placeholder="CLAIM SUBMISSION DATE:" name="cDate" id ="cDate" onblur="return validateDate(document.claimForm.cDate)" >
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
		
		<header>Beneficiary Details</header>
	
	
	
			<section>
						<label class="input" for="bName">
							<i class="icon-append icon-user"></i>
							<input type="text" placeholder="NAME:" name="bName" id ="bName"   onblur="return ValidateName(document.claimForm.bName)" >
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
					
					<label class="input" for="bAddr">
							<i class="icon-append icon-addr"></i>
							<textarea placeholder="--------------BENEFICIARY ADDRESS--------------"  name="bAddr" id="bAddr" 
							rows="4" cols="40" style="font-family: inherit; font-size:medium;" 
							onblur="return  ValidateAddress(document.claimForm.bAddr)" ></textarea>
							
				           <b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					<br>
					<section>
						<label class="input" for="bEmail" font>
							<i class="icon-append icon-email"></i>
							<input type="text" placeholder="EMAIL:" name="bEmail" id ="bEmail"  onblur="return ValidateEmail(document.claimForm.bEmail)" >
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
					
					<section>
						<label class="input" for="bNum">
							<i class="icon-append icon-contact"></i>
							<input type="text" placeholder="CONTACT NUMBER:" name="bNum" id ="bNum"  onblur="return ValidateNumber(document.claimForm.bNum)" >
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
	
			 		<section>
						<label class="input" for="bAge">
							<i class="icon-append icon-age"></i>
							<input type="text" placeholder="AGE:" name="bAge" id ="bAge"  onblur="return  validateNum(document.claimForm.bAge)" >
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
			
		
			
				<footer>
					<input type="submit" value="Claim" class="button">
				</footer>
				</fieldset>
				
				
			</form>
			
		</div>
<center><a href="<%=request.getContextPath()%>/Insurance Claims Processing/InsuranceClaimProcessingHome.jsp" class="btn btn--gray-border">Insurance Claim Processing Home </a></center>	
	
<div class=footer >
Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
</div>

</body>
</html>




