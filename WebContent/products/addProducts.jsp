<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add products</title>
</head>
<body>
	<link rel="stylesheet" href="../style.css" type="text/css" media="screen" />
	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/product">
		<table align="center">
			<caption>
				<h2>
					<font color="blue">Register Page</font>
				</h2>
			</caption>
			<tr>
				<td>Product name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Product price:</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>Product category:</td>
				<td><input type="text" name="category"></td>
			</tr>
			<tr>
				<td>Product number:</td>
				<td><input type="text" name="pnum"></td>
			</tr>
			<tr>
				<td>Product description:</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Product img:</td>
				<td><input type="file" name="img"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="submit">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>