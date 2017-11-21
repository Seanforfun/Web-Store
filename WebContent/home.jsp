<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<!--
    Created by Artisteer v2.6.0.35446
    Base template (without user's data) checked by http://validator.w3.org : "This page is valid XHTML 1.0 Transitional"
    -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Estore</title>

<link rel="stylesheet" href="style.css" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" href="style.ie6.css" type="text/css" media="screen" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" href="style.ie7.css" type="text/css" media="screen" /><![endif]-->

<script type="text/javascript" src="script.js"></script>
<script type="text/javascript">
	var focus_width = 632;
	var focus_height = 320;
	var picPath;
	var linkUrl = "";
	var swfPath = "adImage.swf";
	var sp = "|";
	var banners = new Array("images/screen1.jpg", "images/screen2.jpg",
			"images/screen3.jpg", "images/screen4.jpg", "images/screen5.jpg",
			"images/screen6.jpg");
	var links = new Array("#", "#", "#", "#", "#", "#");

	for (var i = 0; i < banners.length; i++) {
		if (i == banners.length - 1) {
			sp = "";
		}
		picPath += banners[i] + sp;
		var index = picPath.indexOf("undefined");
		if (index != -1) {
			picPath = picPath.substr(index + 9, picPath.length);
		}
		linkUrl += links[i] + sp;
	}
</script>
</head>
<body>
	<div id="art-main">
		<div class="art-sheet">
			<div class="art-sheet-tl"></div>
			<div class="art-sheet-tr"></div>
			<div class="art-sheet-bl"></div>
			<div class="art-sheet-br"></div>
			<div class="art-sheet-tc"></div>
			<div class="art-sheet-bc"></div>
			<div class="art-sheet-cl"></div>
			<div class="art-sheet-cr"></div>
			<div class="art-sheet-cc"></div>
			<div class="art-sheet-body">
				<div class="art-header">
					<div class="art-header-png"></div>
					<div class="art-header-jpeg"></div>
					<div class="art-logo">
						<h1 id="name-text" class="art-logo-name">
							<a href="#">Estore</a>
						</h1>
						<div id="slogan-text" class="art-logo-text">Paradise for
							shopping...</div>
					</div>
				</div>
				<div class="art-nav">
					<div class="l"></div>
					<div class="r"></div>
					<ul class="art-menu">
						<li><a href="#" class="active"><span class="l"></span><span
								class="r"></span><span class="t">main page</span></a></li>
						<li><a href="#"><span class="l"></span><span class="r"></span><span
								class="t">products classification</span></a>
							<ul>
								<li><a href="#">Books,E-books,Audio</a></li>
								<li><a href="#">Electronics</a>
									<ul>
										<li><a href="#">Home use electronics</a></li>
										<li><a href="#">Cellphone</a></li>
										<li><a href="#">Computer, Office</a></li>
									</ul></li>
								<li><a href="#">Furnitures</a></li>
							</ul></li>
						<li><a href="#"><span class="l"></span><span class="r"></span><span
								class="t">About us</span></a></li>
					</ul>
				</div>
				<div class="art-content-layout">
					<div class="art-content-layout-row">
						<div class="art-layout-cell art-content">
							<div class="art-post">
								<div class="art-post-tl"></div>
								<div class="art-post-tr"></div>
								<div class="art-post-bl"></div>
								<div class="art-post-br"></div>
								<div class="art-post-tc"></div>
								<div class="art-post-bc"></div>
								<div class="art-post-cl"></div>
								<div class="art-post-cr"></div>
								<div class="art-post-cc"></div>
								<div class="art-post-body">
									<div class="art-post-inner art-article">
										<div class="art-postmetadataheader">
											<h2 class="art-postheader">Products on Discounts</h2>
										</div>
										<div class="art-postcontent">
											<!-- article-content -->
											<script type="text/javascript" src="mutilpleFlash.js"></script>
											<!-- /article-content -->
										</div>
										<div class="cleared"></div>
									</div>

									<div class="cleared"></div>
								</div>
							</div>

							<div class="art-post">
								<div class="art-post-tl"></div>
								<div class="art-post-tr"></div>
								<div class="art-post-bl"></div>
								<div class="art-post-br"></div>
								<div class="art-post-tc"></div>
								<div class="art-post-bc"></div>
								<div class="art-post-cl"></div>
								<div class="art-post-cr"></div>
								<div class="art-post-cc"></div>
								<div class="art-post-body">
									<div class="art-post-inner art-article">
										<div class="art-postmetadataheader">
											<h2 class="art-postheader">Products on sale</h2>
										</div>
										<div class="art-postcontent">
											<!-- article-content -->
											<p>
												<span class="art-button-wrapper"> <span class="l">
												</span> <span class="r"> </span> <a class="art-button"
													href="${pageContext.request.contextPath}/product?type=show">More products...</a>
												</span>
											
												<span class="art-button-wrapper"> <span class="l">
												</span> <span class="r"> </span> <a class="art-button"
													href="${pageContext.request.contextPath }/products/addProducts.jsp">Add products...</a>
													
												</span>
												
											</p>
											
											<!-- end table -->

											<!-- /article-content -->
										</div>
										<div class="cleared"></div>
									</div>

									<div class="cleared"></div>
								</div>
							</div>
						</div>
						
						
						<div class="art-layout-cell art-sidebar1">
							<div class="art-vmenublock">
								<div class="art-vmenublock-body">
									<div class="art-vmenublockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">Menu</div>
									</div>
									<div class="art-vmenublockcontent">
										<div class="art-vmenublockcontent-tl"></div>
										<div class="art-vmenublockcontent-tr"></div>
										<div class="art-vmenublockcontent-bl"></div>
										<div class="art-vmenublockcontent-br"></div>
										<div class="art-vmenublockcontent-tc"></div>
										<div class="art-vmenublockcontent-bc"></div>
										<div class="art-vmenublockcontent-cl"></div>
										<div class="art-vmenublockcontent-cr"></div>
										<div class="art-vmenublockcontent-cc"></div>
										<div class="art-vmenublockcontent-body">
											<!-- block-content -->
											<ul class="art-vmenu">
												<li><a href="page.html?i1"><span class="l"></span><span
														class="r"></span><span class="t">Main page</span></a></li>
												<li><a href="page.html?i2"><span class="l"></span><span
														class="r"></span><span class="t">More products</span></a></li>
												<li><a href="page.html?i4"><span class="l"></span><span
														class="r"></span><span class="t">Check products</span></a></li>
												<li><a href="page.html?i5"><span class="l"></span><span
														class="r"></span><span class="t">Check cart</span></a></li>
												<li><a href="page.html?i6"><span class="l"></span><span
														class="r"></span><span class="t">Check order</span></a></li>
												<li><a href="page.html?i7"><span class="l"></span><span
														class="r"></span><span class="t">About us</span></a></li>
												<li><a href="page.html?i8"><span class="l"></span><span
														class="r"></span><span class="t">Contact method</span></a></li>
											</ul>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>
							<div class="art-block">
								<div class="art-block-body">
									<div class="art-blockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">User Login</div>
									</div>
									<div class="art-blockcontent">
										<div class="art-blockcontent-tl"></div>
										<div class="art-blockcontent-tr"></div>
										<div class="art-blockcontent-bl"></div>
										<div class="art-blockcontent-br"></div>
										<div class="art-blockcontent-tc"></div>
										<div class="art-blockcontent-bc"></div>
										<div class="art-blockcontent-cl"></div>
										<div class="art-blockcontent-cr"></div>
										<div class="art-blockcontent-cc"></div>
										<div class="art-blockcontent-body">
											<!-- block-content -->
											<div>
												<form method="post" id="loginForm" action="${pageContext.request.contextPath }/login">
													<table>
														<tr>
															<td>Username</td>
															<td><input type="text" value="" name="username"
																id="usernameId"
																style="width: 95px;"><br /></td>
														</tr>
														<tr>
															<td>Password</td>
															<td><input type="text" name="password"
																id="password" style="width: 95px;" /></td>
														</tr>
														<tr>
															<td colspan="2"><input type="checkbox"
																name="remember" value="on" />remember me 
																<input type="checkbox" name="autologin" value="on" />auto-login</td>
														</tr>
														<tr>
															<td><span class="art-button-wrapper"> <span
																	class="l"> </span>
																<span class="r"> </span> <input class="art-button" type="submit" name="loginbtn"
																	value="Login" />
															</span></td>
															<!-- 
																 <td>
																	<span class="art-button-wrapper">
																		<span class="l"> </span>
																		<span class="r"> </span>
																		<input class="art-button" type="submit" name="registerbtn" value="Register" />
																	</span>
																</td> -->
															<td colspan="2" style="width: 51px; "><a href="${pageContext.request.contextPath }/register.jsp">register</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/logout">logout</a></td>
													</table>
												</form>
											</div>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>
							<div class="art-block">
								<div class="art-block-body">
									<div class="art-blockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">Search products</div>
									</div>
									<div class="art-blockcontent">
										<div class="art-blockcontent-tl"></div>
										<div class="art-blockcontent-tr"></div>
										<div class="art-blockcontent-bl"></div>
										<div class="art-blockcontent-br"></div>
										<div class="art-blockcontent-tc"></div>
										<div class="art-blockcontent-bc"></div>
										<div class="art-blockcontent-cl"></div>
										<div class="art-blockcontent-cr"></div>
										<div class="art-blockcontent-cc"></div>
										<div class="art-blockcontent-body">
											<!-- block-content -->
											<div>
												<form method="get" id="newsletterform"
													action="javascript:void(0)">
													<input type="text" value="" name="email" id="s"
														style="width: 95%;" /> <span class="art-button-wrapper">
														<span class="l"> </span> <span class="r"> </span> <input
														class="art-button" type="submit" name="search"
														value="Search" />
													</span>

												</form>
											</div>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>

							<div class="art-block">
								<div class="art-block-body">
									<div class="art-blockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">Contact Information</div>
									</div>
									<div class="art-blockcontent">
										<div class="art-blockcontent-tl"></div>
										<div class="art-blockcontent-tr"></div>
										<div class="art-blockcontent-bl"></div>
										<div class="art-blockcontent-br"></div>
										<div class="art-blockcontent-tc"></div>
										<div class="art-blockcontent-bc"></div>
										<div class="art-blockcontent-cl"></div>
										<div class="art-blockcontent-cr"></div>
										<div class="art-blockcontent-cc"></div>
										<div class="art-blockcontent-body">
											<!-- block-content -->
											<div>
												<img src="images/contact.jpg" alt="an image"
													style="margin: 0 auto; display: block; width: 95%" /> <br />
												<b>Company Information</b><br /> Sean Xiao<br /> E-mail: <a
													href="mailto:yuyang@itcast.cn">xiaob6@mcmaster.ca</a><br />
												<br />
											</div>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="cleared"></div>
				<div class="art-footer">
					<div class="art-footer-t"></div>
					<div class="art-footer-l"></div>
					<div class="art-footer-b"></div>
					<div class="art-footer-r"></div>
					<div class="art-footer-body">
						<a href="#" class="art-rss-tag-icon" title="RSS"></a>
						<div class="art-footer-text">
							<p>
								<a href="#">About Us</a> | <a href="#">Contact Us</a> <br />
								Copyright &#169; 2017 ---. SeanForFun.
							</p>
						</div>
						<div class="cleared"></div>
					</div>
				</div>
				<div class="cleared"></div>
			</div>
		</div>
		<div class="cleared"></div>
	</div>

</body>
<script type="text/javascript">
	window.onload = function(){
		var username = document.getElementById("usernameId");
		username.value = window.decodeURIComponent("${cookie.remember.value}","utf-8");
	}
</script>
</html>
