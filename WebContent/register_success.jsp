<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath }/home.jsp">
	<link rel="stylesheet" href="style.css" type="text/css" media="screen" />
	
	<h1><font color="red">Resgister success! Junp to <a href="${pageContext.request.contextPath}/home.jsp">home</a> in <span id="spanId">3</span> seconds;</font> </h1>
</body>
<script type="text/javascript">
	var interval;
	window.onload = function(){
		interval = window.setInterval("fun()", 1000);
	}
	
	function fun(){
		var span = document.getElementById("spanId");
		var content = span.innerHTML;
		
		if(0 == interval){
			window.clearInterval(interval);
			return;
		}
		span.innerHTML = content - 1;
	}
</script>
</html>