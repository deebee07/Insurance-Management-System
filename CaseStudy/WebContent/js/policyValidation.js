///////////////// Health Registration/////////////////





function customerIdNum(inputtxt) {

	if (isNaN(inputText.value)) {
		alert("Enter a Number");
		inputText.value = "";
		return false;
	} else if (inputText.value === "") {
		alert("Enter a Numeric Value");
		inputText.value = "";
		return false;
	}

	else {
		var iChars = "!@#$%^&*()+=-[]\\\';/{}|\":<>?";

		for ( var i = 0; i < inputText.value.length; i++) {
			if (iChars.indexOf(inputText.value.charAt(i)) != -1) {
				var check = true;
			}
		}

		if (check) {
			alert("Special characters. \nThese are not allowed.\n Please remove them and try again.");
			inputText.value = "";
			return false;
		} else
			return true;

	}
}

/*function alphaNumericPolicyId(inputtxt) {
	var numbers = /^[0-9]+$/;

	if (inputtxt.value.match(numbers)) {

		return true;
	} else {
		alert('Please enter valid Policy Id in number format !');
		inputtxt.value = "";
		document.getElementById("PID").focus();

		return false;
	}
}

function tenureNum(inputtxt) {
	var numbers1 = /^[0-9]+$/;

	if (inputtxt.value.match(numbers1)) {

		return true;
	}

	else {
		alert('Please enter valid number !');

		inputtxt.value = "";

		return false;
	}

}

function validateDate1(inputText) {

	var ree = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[\/]\d{4}$/;

	if (inputText.value.match(ree)) {

		return true;
	} else if (inputText.value == "") {
		alert("Please enter Date");
		return false;
	} else {
		alert("Invalid Date format! Valid Format is (DD/MM/YYYY) ");
		inputText.value = "";
		return false;
	}

}

function validateDate2(inputText) {

	 var ree = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[\/]\d{4}$/;

		if (inputText.value.match(ree)) {
			var strDate = inputText.value;
			var dateParts = strDate.split("/");

			var before = new Date(dateParts[2], (dateParts[1] - 1), dateParts[0]);

			

		} else if (inputText.value === "") {
			alert("Enter the Date");

			return false;
		} else {
			alert("Invalid Date format DD/MM/YYYY Accepted");

			return false;
		}
	}

function premiumAmountNum(inputtxt) {
	var numbers = /^[0-9]+$/;

	if (inputtxt.value.match(numbers)) {

		return true;
	}

	else {
		alert('Please enter premium amount in number format!');

		inputtxt.value = "";

		return false;
	}

}

function paymentModeDropDown() {
	var e = document.getElementById("pMode").value;
	if (e === 'pMode') {
		alert("Select payment mode");
		return false;
	}
	return true;
}

function paymentFreqDropDown() {
	var e = document.getElementById("pFrequency").value;
	if (e === 'pFrequency') {
		alert("Select payment frequency");
		return false;
	}
	return true;
}
function validateDate3(inputText) {

	 var ree = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[\/]\d{4}$/;

	if (inputText.value.match(ree)) {
		var strDate = inputText.value;
		var dateParts = strDate.split("/");

		var before = new Date(dateParts[2], (dateParts[1] - 1), dateParts[0]);

		var now = new Date();
		if (before < now) {
			return true;
			// selected date is in the past
		} else {
			alert("Entered Date cant be a Future Date")
			return false;
		}

	} else if (inputText.value === "") {
		alert("Enter the Date");

		return false;
	} else {
		alert("Invalid Date format DD/MM/YYYY Accepted");

		return false;
	}
}



 * function validatePolicyRegistration() {
 * 
 * if (customerIdNum(document.getElementById("ID").value) == true &&
 * alphaNumericPolicyId(document.getElementById("PID").value) == true &&
 * tenureNum(document.getElementById("tenure").value) == true &&
 * validateDate1(document.getElementById("cDate").value) == true &&
 * validateDate2(document.getElementById("eDate").value) == true &&
 * paymentFreqDropDown() == true && paymentModeDropDown() == true &&
 * premiumAmountNum(document.getElementById("pAmount").value) == true)
 * 
 * return true;
 * 
 * else return false; }
 

function validatePolicyRegistration()
{
	if(customerIdNum(document.registerHealthPolicy.id)&&alphaNumericPolicyId(document.registerHealthPolicy.pid)&&
			tenureNum(document.registerHealthPolicy.tenure)&& validateDate3(document.registerHealthPolicy.cDate) &&
			 validateDate2(document.registerHealthPolicy.eDate) &&paymentFreqDropDown()
			 &&paymentModeDropDown()&& premiumAmountNum(document.registerHealthPolicy.pAmount))
	{
		alert("Registering Policy...");
		return true;
	}
	else
	{
		return false;
	}
}


// ///////////////////



function deleteHealthUsingPolicyRefNum(PID) {

	var policynum = /^[A-Z][0-9]/;
	if (PID.value.match(policynum)) {
		return true;
	} else {
		alert("Enter a valid policy reference number,special characters not allowed !");
		 PID.value = "";
		return false;
	}
}

function alphaNumericVechileNum(inputtxt) {
	var letters = /^[0-9a-zA-Z]+/;
	if (inputtxt.value.match(letters)) {

		return true;
	} else {
		alert('Please enter alphanumeric characters only,special characters are not allowed !');

		inputtxt.value = "";
		document.getElementById("vNum").focus();

		return false;
	}
}

 * function alphaNumericLiceneNum(inputtxt) { var letters = /^[0-9a-zA-Z]+/; if
 * (inputtxt.value.match(letters)) {
 * 
 * return true; } else { alert('Please enter alphanumeric characters
 * only,special characters are not allowed !');
 * 
 * inputtxt.value = ""; document.getElementById("lNum").focus();
 * 
 * return false; }
 
}
function alphaNumericVehicleType() {
	var e = document.getElementById("vType").value;
	if (e === 'vType') {
		alert("Select Vehicle Type");
		return false;
	}
	return true;
}
function alphaNumericLiceneNum()
{
	var lNo=document.registerVehiclePolicy.lNum.value;
	if(lNo==null||lNo=="")
	{
		alert("Enter your License no.!");
		document.registerVehiclePolicy.lNum.focus();
		return false;
	}
	if(isNaN(lNo))
	{
		alert("Enter numeric value in license no.!");
		document.registerVehiclePolicy.lNum.value="";
		document.registerVehiclePolicy.lNum.focus();
		return false;
	}
	if(lNo.length!=10)
	{
		alert("Invalid length of contact no.!");
		document.registerVehiclePolicy.lNum.value="";
		document.registerVehiclePolicy.lNum.focus();
		return false;		
	}
	return true;
}
function alphaNumericVechileNum()
{
	var vNo=document.registerVehiclePolicy.vNum.value;
	if(vNo==null||vNo=="")
	{
		alert("Enter your Vehicle no.!");
		document.registerVehiclePolicy.vNum.focus();
		return false;
	}
	var letters = /^[0-9A-Z]+/;
	if (inputtxt.value.match(letters)) {

		return true;
	} else {
		alert('Please enter alphanumeric characters only,special characters are not allowed !');

		inputtxt.value = "";
		document.getElementById("vNum").focus();

		return false;
	}
	if(vNo.length!=8)
	{
		alert("Invalid length of Vehicle no.!");
		document.registerVehiclePolicy.vNum.value="";
		document.registerVehiclePolicy.vNum.focus();
		return false;		
	}
	return true;
}

 * var email = document.mobilenumbervalidation.email_id.value; atpos =
 * email.indexOf("@"); dotpos = email.lastIndexOf("."); if (email == "" || atpos <
 * 1 || ( dotpos - atpos < 2 )) { alert("Please enter correct email ID");
 * document.mobilenumbervalidation.email_id.focus() ; return false; }
 * 
 * return( true ); }
 * 
 */ 