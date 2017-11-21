<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show products</title>
</head>
<body>
	<link rel="stylesheet" href="../style.css" type="text/css"
		media="screen" />
	<div class="art-content-layout overview-table">
		<div class="art-content-layout-row">
			<c:forEach items="${products}" var="p" varStatus="vs">
				<div class="art-layout-cell">
					<div class="overview-table-inner">
						<h4>${p.name }</h4>
						<img src="${p.imgurl }" width="55px" height="55px" alt="an image"
							class="image" />
						<p>price: $${p.price }</p>
						<p><a href="${pageContext.request.contextPath }/cartmanage?id=${p.id}">Add to cart</a></p>
					</div>
				</div>
				<c:if test="${vs.count%5==0}">
		</div>
		<div class="art-content-layout-row">
			</c:if>
			</c:forEach>
			<!-- end cell -->
		</div>

		<!-- end row -->
	</div>
	<!-- end table -->
</body>
</html>