<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${requestScope["register.message"] }<br>
	<link rel="stylesheet" href="style.css" type="text/css" media="screen" />
	<form
		action="${pageContext.request.contextPath }/usermanage?type=register"
		method="post"
		onsubmit="return checkForm()">
		<table align="center">
			<caption>
				<h2>
					<font color="blue">Register Page</font>
				</h2>
			</caption>
			<tr>
				<td>username</td>
				<td><input type="text" name="username" id="username"><font color="red">${validation["register.username.error"] }</font><span id="username_msg"></span></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password" id="password"><span id="password_msg"><font color="red">${validation["register.password.error"] }</font></span></td>
			</tr>
			<tr>
				<td>re-password</td>
				<td><input type="password" name="repassword" id="repassword"><span id="repassword_msg"></span></td>
			</tr>
			<tr>
				<td>nickname</td>
				<td><input type="text" name="nickname" id="nickname"><font color="red">${validation["register.nickname.error"] }</font><span id="nickname_msg"></span></td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td><input type="text" name="email" id="email"><font color="red">${validation["register.email.error"] }</font><span id="email_msg"></span></td>
			</tr>
			<tr>
				<td>verify code</td>
				<td><input type="text" name="verify" id="verify"><img id="v"
					src="${pageContext.request.contextPath }/usermanage?type=verify"
					onclick="change()"><span id="verify_msg"></span></td>
			</tr>
			<tr>
				<td><input type="submit" value="register"></td>
				<td><input type="reset" value="cancel"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function change() {
		var v = document.getElementById("v");
		v.src="${pageContext.request.contextPath}/usermanage?type=verify&time=" + new Date().getTime();
	}
	
	function checkForm(){
		var f1 = checkEmpty("username");
		var f2 = checkEmpty("password");
		var f3 = checkEmpty("repassword");
		var f4 = checkEmpty("nickname");
		var f5 = checkEmpty("email");
		var f6 = checkEmpty("verify");
		if(f1&&f2&&f3&&f4&&f5&&f6){
			var f7 = checkPassword();
			return f7;
		}else{
			return f1&&f2&&f3&&f4&&f5&&f6;
		}
	}
	
	function checkEmpty(fieldName)
	{
		var test = document.getElementById(fieldName).value;
		var reg = /^\s*$/;
		var result = !reg.test(test);
		
		if(result == false)
		{
			giveInfo(fieldName);
		}
		
		return result;
		
//		if(!reg.test(fieldName)){
//			return true;
//		}else{
//			return false;
//		}
	}
	
	function giveInfo(fieldName){
		var fieldNameNew = fieldName + "_msg";
		var test = document.getElementById(fieldNameNew);
		test.innerHTML = "<font color=" + "red" + ">" + fieldName + " cannot be empty!</font>";
	}
	
	function checkPassword(){
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		
		if(password == repassword){
			return true;			
		}else{
			var repassword = document.getElementById("repassword_msg");
			repassword.innerHTML = "<font color=" + "red" + "> passwords should be same!</font>";
			return false;
		}
	}
</script>
</html>