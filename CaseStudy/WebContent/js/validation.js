/*function validatePhotoId() {
	var x = document.getElementById("photoid").value;
	if (x == null || x == "") {
		alert('Photo Unique Id can\'t be null');
		return false;
	} else if (x.length != 6) {
		alert('Photo Unique Id length is 6');
		return false;
	} else
	{
		if(x==="000000")
		{
			alert("PhotoId cant be 000000");
			return false;
		}
		else
		{
			var iChars = "!@#$%^&*()+=-[]\\\';/{}|\":<>?";

			for (var i = 0; i < x.length; i++) {
				if (iChars.indexOf(x.charAt(i)) != -1) 
				{
					var check=true;}
			}

			if(check)
			{
				alert ("Special characters. \nThese are not allowed.\n Please remove them and try again.");
				return false;
			}
			else
				return true;
		}

	}
}


function validateClaimRegistration(ID, PRNum, cAmount, cDate, bName, bAddr,
		bEmail, bNum, bAge) {

	if (validateNum(ID) == true && ValidatePolicyRefNum(PRNum) == true
			&& validateNum(cAmount) == true && validateDate(cDate) == true
			&& ValidateAddress(address) == true
			&& ValidateEmail(bEmail) == true && ValidateNumber(bNum) == true
			&& validateNum(bAge) == true)

		return true;

	else
		return false;

}

function validateUpdate(name, dob, email, address, number) {

	if (ValidateName(name) == true && ValidateNumber(number) == true
			&& validateDate(dob) == true && ValidateEmail(email) == true
			&& ValidateAddress(address) == true)

		return true;

	else
		return false;

}

function ValidatePolicyRefNum(policyrefnum) {

	var policynum = /^[H|V][0-9]/
	if (policyrefnum.value.match(policynum)) {
		return true;
	} else {
		alert("Enter a valid policy reference number");
		return false;
	}
}

function validateAddressId() {
	var x = document.getElementById("addressid").value;

	if (x == null || x == "") {
		alert('Address Unique Id can\'t be NULL');
		return false;
	} else if (x.length != 5) {
		alert('Address Unique Id length is 5');
		return false;
	} else
	{if(x==="00000")
	{
		alert("Address Id cant be 00000");
		return false;
	}
	else{

		var iChars = "!@#$%^&*()+=-[]\\\';/{}|\":<>?";

		for (var i = 0; i < x.length; i++) {
			if (iChars.indexOf(x.charAt(i)) != -1) 
			{
				var check=true;}
		}

		if(check)
		{
			alert ("Special characters. \nThese are not allowed.\n Please remove them and try again.");
			return false;
		}
		else
			return true;
	}}
}
function alphaNumericCheck(inputText)
{ 
	var letters = "^[a-zA-Z0-9_.-]*$";
	if(inputText.value.match(letters))
		{
		return true;
		}
	else
		{
		alert("AlphaNumeric characters need to be entered");
		return false;
		}
	
}
function validateNum(inputText) {

	if (isNaN(inputText.value)) {
		alert("Enter a Number")
		return false;
	} 
	else if (inputText.value === "") {
		alert("Enter a Numeric Value")
		return false;
	}

	else
	{
		var iChars = "!@#$%^&*()+=-[]\\\';/{}|\":<>?";

		for (var i = 0; i < inputText.value.length; i++) {
			if (iChars.indexOf(inputText.value.charAt(i)) != -1) 
			{
				var check=true;}
		}

		if(check)
		{
			alert ("Special characters. \nThese are not allowed.\n Please remove them and try again.");
			return false;
		}
		else
			return true;

	}
}
function ValidateNumber(inputText) {
	var phoneno = /^\d{10}$/;
	if (inputText.value.match(phoneno)) {

		if(inputText.value==="0000000000")
		{
			alert("Mobile number cant be 0000000000");
			return false;
		}
		else{
			return true;
		}
	} else if (inputText.value === "") {
		alert("Enter a valid Mobile Number");

		return false;
	} else {
		alert("Mobile Number should be of 10 digits and Number");
		return false;
	}
}

function validateDates(inputText1, inputText2) {
	ree = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[\/]\d{4}$/;

	if (inputText1.value.match(ree)) {
		if (inputText2.value.match(ree)) {
			var strDate1 = inputText1.value;
			var strDate2 = inputText2.value;

			var dateParts1 = strDate1.split("/");
			var dateParts2 = strDate2.split("/");

			var before1 = new Date(dateParts1[2], (dateParts1[1] - 1),
					dateParts1[0]);
			var before2 = new Date(dateParts2[2], (dateParts2[1] - 1),
					dateParts2[0]);

			var now = new Date();
			if (before1 < now && before2 < now) {
				return true;
				// selected date is in the past
			} else {
				alert("Entered Date cant be a Future Date")
				return false;
			}
		} else if (inputText2.value === "") {
			alert("Enter the Date 2");

			return false;
		} else {
			alert("Invalid Date format DD/MM/YYYY Accepted");

			return false;
		}
	} else if (inputText1.value === "") {
		alert("Enter the Date 1");

		return false;
	} else {
		alert("Invalid Date format DD/MM/YYYY Accepted");

		return false;
	}

}

function validateDate(inputText) {

	ree = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[\/]\d{4}$/;

	if (inputText.value.match(ree)) {
		var strDate = inputText.value;
		var dateParts = strDate.split("/");

		var before = new Date(dateParts[2], (dateParts[1] - 1), dateParts[0]);

		var leastDate=new Date(1900,1,24);

		var now = new Date();
		if (before < now &&before>leastDate) {
			return true;
			// selected date is in the past
		} else {
			alert("Entered Date not valid")
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

function ValidateEmail(mail) {
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail.value)) {
		return (true)
	}
	alert("You have entered an invalid email address!")
	return (false)
}

function ValidateAddress(Address) {
	if (Address.value === "") {
		alert("Enter the Address");

		return false;
	}
	if (Address.length < 20) {
		alert("Enter more details about your address");
		return false;
	} else

	{
		var iChars = "!@#$%^&*()+=-[]\\\';/{}|\":<>?";

		for (var i = 0; i < Address.value.length; i++) {
			if (iChars.indexOf(Address.value.charAt(i)) != -1) 
			{
				var check=true;}
		}

		if(check)
		{
			alert ("Special characters. \nThese are not allowed.\n Please remove them and try again.");
			return false;
		}
		else
			return true;
	}

}

function ValidateName(Name) {


	if (Name.value === "") {
		alert("Enter the Name");

		return false;
	} else if (!(isNaN(Name.value))) {
		alert("Name cant be a Number");
		return false;

	} else

		var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?";
	for (var i = 0; i < Name.value.length; i++) {
		if (iChars.indexOf(Name.value.charAt(i)) != -1) 
		{
			var check=true;}
	}

	if(check)
	{
		alert ("Your Name has special characters. \nThese are not allowed.\n Please remove them and try again.");
		return false;
	}
	else
		return true;
}

function validateAddressProof() {
	var e = document.getElementById("addrproof").value;
	if (e == 'addressproof') {
		alert("Select AddressProof");
		return false;
	}
	return true;
}

function validatePhotoProof(photoproof) {
	var e = document.getElementById("photoproof").value;
	if (e == 'photoproof') {
		alert("Select PhotoProof");
		return false;
	}
	return true;
}



function validate() {



	if (validatePhotoId()&&validateAddressId()&&ValidateNumber(document.getElementById("number"))&&validateDate(document.getElementById("dob"))&&ValidateEmail(document.getElementById("email"))&&ValidateAddress(document.getElementById("address"))&&ValidateName(document.getElementById("name"))&&validateAddressProof()&&ValidatingPhotoProof()&&ValidatingAddressProof()) 
	{
		alert("hi");
		var ph=document.formCustomer.photoproof.value;
		
		alert(ph);
		return true;


	}


	else
		return false;

}

function ValidatingPhotoProof()
{
	var ph=document.formCustomer.photoproof.value;
	
	

	if(ph=="photoproof")
	{
		alert("Select photo proof");
		return false;
	}
	else
	{
		return true;
	}
}




function ValidatingAddressProof()
{
	var ph=document.formCustomer.addrproof.value;
	
	

	if(ph=="addrproof")
	{
		alert("Select addrproof");
		return false;
	}
	else
	{
		return true;
	}
}



 */

function validatePhotoId() {
	var x = document.getElementById("photoid").value;
	if (x == null || x == "") {
		alert('Photo Unique Id can\'t be null');
		x = "";
		return false;
	} else if (x.length != 6) {
		alert('Photo Unique Id length is 6');
		x = "";
		return false;
	} else {
		if (x === "000000") {
			alert("PhotoId cant be 000000");
			x = "";
			return false;
		} else {
			var iChars = "!@#$%^&*()+=-[]\\\';/{}|\":<>?";

			for ( var i = 0; i < x.length; i++) {
				if (iChars.indexOf(x.charAt(i)) != -1) {
					var check = true;
				}
			}

			if (check) {
				alert("Special characters. \nThese are not allowed.\n Please remove them and try again.");
				x = "";
				return false;
			} else
				return true;
		}

	}
}

function validateClaimRegistration(ID, PRNum, cAmount, cDate, bName, bAddr,
		bEmail, bNum, bAge) {

	if (validateNum(ID) == true && ValidatePolicyRefNum(PRNum) == true
			&& validateNum(cAmount) == true && validateDate(cDate) == true
			&& ValidateAddress(address) == true
			&& ValidateEmail(bEmail) == true && ValidateNumber(bNum) == true
			&& validateNum(bAge) == true)

		return true;

	else
		return false;

}

function validateUpdate(name, dob, email, address, number) {

	if (ValidateName(name) == true && ValidateNumber(number) == true
			&& validateDate(dob) == true && ValidateEmail(email) == true
			&& ValidateAddress(address) == true)

		return true;

	else
		return false;

}

function ValidatePolicyRefNum(policyrefnum) {

	var policynum = /^[H|V][0-9]/
	if (policyrefnum.value.match(policynum)) {
		return true;
	} else {
		alert("Enter a valid policy reference number");
		policyrefnum.value = "";
		return false;
	}
}


function validateAddressId() {
	var x = document.getElementById("addressid").value;

	if (x == null || x == "") {
		alert('Address Unique Id can\'t be NULL');
		x.value = "";
		return false;
	} else if (x.length != 5) {
		alert('Address Unique Id length is 5');
		x.value = "";
		return false;
	} else {
		if (x === "00000") {
			alert("Address Id cant be 00000");
			x.value = "";
			return false;
		} else {

			var iChars = "!@#$%^&*()+=-[]\\\';/{}|\":<>?";

			for ( var i = 0; i < x.length; i++) {
				if (iChars.indexOf(x.charAt(i)) != -1) {
					var check = true;
				}
			}

			if (check) {
				alert("Special characters. \nThese are not allowed.\n Please remove them and try again.");
				x.value = "";
				return false;
			} else
				return true;
		}
	}
}
function alphaNumericCheck(inputText) {
	var letters = "^[a-zA-Z0-9_.-]*$";
	if (inputText.value.match(letters)) {
		return true;
	} else {
		alert("AlphaNumeric characters need to be entered");
		inputText.value = "";
		return false;
	}

}

// Licence Number

function driver_licence() {

	var strFilter = /^[A-Z]{2}[0-9]{2}[" "]{1}[0-9]{11}$/;
	var obj = document.getElementById("lNum");

	if (!strFilter.test(obj.value)) {
	    alert("Please enter valid 16-digit license number");
	     obj.value = "";
	    return false;
	}
}
function vehicleNumber() {

	var strFilter = /^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$/;
	var obj = document.getElementById("vNum");

	if (!strFilter.test(obj.value)) {
	    alert("Please enter valid 10-digit Vehicle number");
	     obj.value = "";
	    return false;
	}
}



// customer Id number
function validateNum(inputText) {

	if (inputText == null || inputText == "") {
		alert('Field can\'t be NULL');
		inputText.value = "";
		return false;
	} else if (isNaN(inputText.value)) {
		alert("Enter a Number");
		inputText.value = "";
		return false;
	}

	else if (inputText.value === "") {
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
// CLAIM AGE
function validateNum5(inputText) {

	if (inputText == null || inputText == "") {
		alert('Field can\'t be NULL');
		inputText.value = "";
		return false;
	} else if (isNaN(inputText.value)) {
		alert("Enter a Number");
		inputText.value = "";
		return false;
	}

	else if (inputText.value === "") {
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


// premium amount
function validateNum1(inputText) {

	if (inputText == null || inputText == "") {
		alert('Premium Amount can\'t be NULL');
		inputText.value = "";
		return false;
	} else if (isNaN(inputText.value)) {
		alert("Enter a Number");
		inputText.value = "";
		return false;
	}

	else if (inputText.value === "") {
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
function ValidateNumber(inputText) {
	var phoneno = /^\d{10}$/;
	if (inputText.value.match(phoneno)) {

		if (inputText.value === "0000000000") {
			alert("Mobile number cant be 0000000000");
			inputText.value = "";
			return false;
		} else {
			return true;
		}
	} else if (inputText.value === "") {
		alert("Enter a valid Mobile Number");
		inputText.value = "";
		return false;
	} else {
		alert("Mobile Number should be of 10 digits and Number");
		inputText.value = "";
		return false;
	}
}

function validateDates(inputText1, inputText2) {
	ree = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[\/]\d{4}$/;

	if (inputText1.value.match(ree)) {
		if (inputText2.value.match(ree)) {
			var strDate1 = inputText1.value;
			var strDate2 = inputText2.value;

			var dateParts1 = strDate1.split("/");
			var dateParts2 = strDate2.split("/");

			var before1 = new Date(dateParts1[2], (dateParts1[1] - 1),
					dateParts1[0]);
			var before2 = new Date(dateParts2[2], (dateParts2[1] - 1),
					dateParts2[0]);

			var now = new Date();
			if (before1 < now && before2 < now) {
				return true;
				// selected date is in the past
			} else {
				alert("Entered Date cant be a Future Date")
				inputText1.value = "";
				inputText2.value = "";
				return false;
			}
		} else if (inputText2.value === "") {
			alert("Enter the Date 2");
			inputText2.value = "";
			return false;
		} else {
			alert("Invalid Date format : DD/MM/YYYY");
			inputText1.value = "";
			inputText2.value = "";
			return false;
		}
	} else if (inputText1.value === "") {
		alert("Enter the Date 1");
		inputText1.value = "";

		return false;
	} else {
		alert("Invalid Date format : DD/MM/YYYY");
		inputText1.value = "";
		inputText2.value = "";
		return false;
	}

}
function validateDate(inputText) {

	ree = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[\/]\d{4}$/;

	if (inputText.value.match(ree)) {
		var strDate = inputText.value;
		var dateParts = strDate.split("/");

		var before = new Date(dateParts[2], (dateParts[1] - 1), dateParts[0]);

		var leastDate = new Date(1900, 1, 24);

		var now = new Date();
		if (before < now && before > leastDate) {
			return true;
			// selected date is in the past
		} else {
			alert("Entered Date not valid");
			inputText.value = "";
			return false;
		}

	} else if (inputText.value === "") {
		alert("Enter the Date");
		inputText.value = "";
		return false;
	} else {
		alert("Invalid Date format : DD/MM/YYYY ");
		inputText.value = "";
		return false;
	}
}

// commencement date
function validateDatePolicy(inputText) {

	ree = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[\/]\d{4}$/;

	if (inputText.value.match(ree)) {
		var strDate = inputText.value;
		var dateParts = strDate.split("/");

		var before = new Date(dateParts[2], (dateParts[1] - 1), dateParts[0]);

		var leastDate = new Date(1900, 1, 24);

		var now = new Date();

		if ((before <= now) && (before > leastDate)) {
			return true;
			// selected date is in the past
		} else {
			alert("Entered Date not valid");
			inputText.value = "";
			return false;
		}

	} else if (inputText.value == "") {
		alert("Enter the Date");
		inputText.value = "";
		return false;
	} else {
		alert("Invalid Date format : DD/MM/YYYY");
		inputText.value = "";
		return false;
	}
}

// end date

function validateEndDatePolicy(inputText) {

	ree = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[\/]\d{4}$/;

	if (inputText.value.match(ree)) {
		var strDate = inputText.value;
		var endDate = document.registerHealthPolicy.eDate.value;
		var dateParts = strDate.split("/");

		var before = new Date(dateParts[2], (dateParts[1] - 1), dateParts[0]);

		var leastDate = document.registerHealthPolicy.cDate.value;

		var now = new Date();
		if (endDate > leastDate) {
			return true;
			// selected date is in the past
		} else {
			alert("Entered Date not valid");
			inputText.value = "";
			return false;
		}

	} else if (inputText.value === "") {
		alert("Enter the Date");
		inputText.value = "";
		return false;
	} else {
		alert("Invalid Date format : DD/MM/YYYY ");
		inputText.value = "";
		return false;
	}
}

function ValidateEmail(mail) {
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail.value)) {
		return true;
	}
	alert("You have entered an invalid email address!");
	mail.value = "";
	return false;
}

function ValidateAddress(Address) {
	if (Address.value === "") {
		alert("Enter the Address");
		Address.value = "";
		return false;
	}
	if (Address.length < 20) {
		alert("Enter more details about your address");
		Address.value = "";
		return false;
	} else

	{
		var iChars = "!@#$%^&*()+=-[]\\\';/{}|\":<>?";

		for ( var i = 0; i < Address.value.length; i++) {
			if (iChars.indexOf(Address.value.charAt(i)) != -1) {
				var check = true;
			}
		}

		if (check) {
			alert("Special characters. \nThese are not allowed.\n Please remove them and try again.");
			Address.value = "";
			return false;
		} else
			return true;
	}

}

function ValidateName(Name) {

	if (Name.value === "") {
		alert("Enter the Name");
		Name.value = "";
		return false;
	} else if (!(isNaN(Name.value))) {
		alert("Name cant be a Number");
		Name.value = "";
		return false;

	} else

		var iChars = "!@#$%~^&*()+=-[]\\\';,./{}|\":<>?_ ";
	for ( var i = 0; i < Name.value.length; i++) {
		if (iChars.indexOf(Name.value.charAt(i)) != -1) {
			var check = true;
		}
	}

	if (check) {
		alert("Your Name has special characters. \nThese are not allowed.\n Please remove them and try again.");
		Name.value = "";
		return false;
	} else
		return true;
}

function validateAddressProof() {
	var e = document.getElementById("addrproof").value;
	if (e == 'addressproof') {
		alert("Select AddressProof");
		document.getElementById("addrproof").value = "";
		return false;
	}
	return true;
}

function validatePhotoProof(photoproof) {
	var e = document.getElementById("photoproof").value;
	if (e == 'photoproof') {
		alert("Select PhotoProof");
		document.getElementById("photoproof").value = "";
		return false;
	}
	return true;
}
function validatePaymentMode() {
	var e = document.getElementById("pMode").value;
	if (e == 'pMode') {
		alert("Select Payment Mode");

		return false;
	}
	return true;
}

function validatePaymentFrequency() {
	var e = document.getElementById("pFrequency").value;
	if (e == 'pFrequency') {
		alert("Select Payment Frequency");

		return false;
	}
	return true;
}

function validate() {

	if (validatePhotoId() && validateAddressId()
			&& ValidateNumber(document.getElementById("number"))
			&& validateDate(document.getElementById("dob"))
			&& ValidateEmail(document.getElementById("email"))
			&& ValidateAddress(document.getElementById("address"))
			&& ValidateName(document.getElementById("name"))/* &&validateAddressProof() */
			&& ValidatingPhotoProof() && ValidatingAddressProof()) {
		alert("hi");
		var ph = document.formCustomer.photoproof.value;

		alert(ph);
		return true;

	}

	else
		return false;

}

function ValidatingPhotoProof() {
	var ph = document.formCustomer.photoproof.value;

	if (ph == "photoproof") {
		alert("Select photo proof");
		document.formCustomer.photoproof.value = "";
		return false;
	} else {
		return true;
	}
}

function ValidatingAddressProof() {
	var ph = document.formCustomer.addrproof.value;

	if (ph == "addrproof") {
		alert("Select addrproof");
		document.formCustomer.addrproof.value = "";
		return false;
	} else {
		return true;
	}
}

function alphaNumericVehicleType() {
	var e = document.getElementById("vType").value;
	if (e == 'vType') {
		alert("Select Vehicle Type");
		
		return false;
		e.value="";
	}
	return true;
}
function validatePaymentMode() {
	var e = document.getElementById("pMode").value;
	if (e == 'pMode') {
		alert("Select Payment Mode");
		return false;
	}
	return true;
}

