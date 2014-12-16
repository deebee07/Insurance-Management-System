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
	
		
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/validation.js"></script>
<title>CLAIM MODIFICATION</title>
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
	
		<div class="body body-s">
		
<%


   HttpSession hsession = request.getSession(true);
   hsession.setAttribute("claimAction", "claimModify");
   ClaimProcessing cp=(ClaimProcessing)request.getAttribute("claimProcessing");
   String claimId=(String)request.getAttribute("claimId");
	
	
   %>		
<form  action="<%=request.getContextPath()%>/ClaimController" name="claimForm" method="post"  class="form">
			<fieldset>
				<header>Claim Registration form</header>
				
				
					<section>
						<label class="input" for="ID">
							<i ></i>
							CLAIM ID:<input type="text" placeholder="CLAIM ID:" name="ID" id ="ID" readonly="readonly" value=<%=claimId %> >
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
					
				
					
					
		
		            <section>
						<label class="input" for="cAmount">
							<i ></i>
							CLAIM AMOUNT:<input type="text" placeholder="CLAIM AMOUNT:" name="cAmount" id ="cAmount" value=<%=cp.getClaimAmount() %>  onblur="return validateNum(document.claimForm.cAmount)" >
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
		
		
			
		
		<header>Beneficiary Details</header>
	
	
	
			<section>
						<label class="input" for="bName">
							<i ></i>
							NAME:<input type="text" placeholder="NAME:" name="bName" id ="bName" value=<%=cp.getBenName() %> onblur="return ValidateName(document.claimForm.bName)">
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
					
					<label class="input" for="bAddr">
							<i ></i>
							ADDRESS:</br><textarea placeholder="--------------BENEFICIARY ADDRESS--------------"  name="bAddr" id="bAddr" rows="4" cols="40" style="font-family: inherit; font-size:medium;"
							 onblur="return  ValidateAddress(document.claimForm.bAddr)" > <%=cp.getBenAddress() %></textarea>
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					<br>
					<section>
						<label class="input" for="bEmail">
							<i ></i>
							EMAIL ID:<input type="text" placeholder="EMAIL:" name="bEmail" id ="bEmail" value=<%=cp.getBenEmail() %> onblur="return ValidateEmail(document.claimForm.bEmail)" >
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
					
					<section>
						<label class="input" for="bNum">
							<i ></i>
							CONTACT NO:<input type="text" placeholder="CONTACT NUMBER:" name="bNum" id ="bNum" value=<%=cp.getBenContactNo() %> onblur="return ValidateNumber(document.claimForm.bNum)">
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
	
			 		<section>
						<label class="input" for="bAge">
							<i ></i>
							AGE:<input type="text" placeholder="AGE:" name="bAge" id ="bAge" value=<%=cp.getBenAge() %>  onblur="return  validateNum(document.claimForm.bAge)" >
							<b class="tooltip tooltip-bottom-right"><font color="red">Required Field *</font></b>
						</label>
					</section>
			
		
			
				<footer>
					<input type="submit" value="Modify" class="button">
				</footer>
				</fieldset>
				
				
			</form>
			
		</div>

<div class=footer>
Copyright © 2014 <a href="#">newindiaassurance@ltd</a>
</div>

</body>
</html>




