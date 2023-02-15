<html>

<head>
<script src="/IGRPortalWeb/js1/md5.min.js"></script>

</head>
<body>
<form action="" onsubmit="testPassword();">
<input type="text" name="a" id="a"/>
<input type="submit"/>
</form>

</body>
<script type="text/javascript">
function testPassword() {
    var strength = 0;
	var a = document.getElementById('a').value;
	//alert(a);
	//Regular Expressions.
    var regex = new Array();
    regex.push("[A-Z]"); //Uppercase Alphabet.
    regex.push("[a-z]"); //Lowercase Alphabet.
    regex.push("[0-9]"); //Digit.
    regex.push("[!@#$]"); //Special Character.
    var passed = 0;
    
    
    
    if(a.length>=6 && a.length <=8 && new RegExp(regex[0]).test(a) && new RegExp(regex[1]).test(a) && new RegExp(regex[2]).test(a) && new RegExp(regex[3]).test(a)){
    	alert('true');
    	return true;
    }
    else{
    	alert('Password must have maximum 8 character and minimum 6 character and must contain lower,upper case letter, digit, and one special character (!@#$)');
    	return false;
    }
}
/* var hash = md5('hello');
alert(hash); 
alert('hello'); */
</script>
</html>