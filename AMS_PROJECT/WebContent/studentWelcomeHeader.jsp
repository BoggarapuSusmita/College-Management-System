<!DOCTYPE html>
<%@page import="cms.model.StudentDao"%>
<%@page import="cms.db.Student"%>
<html lang="en">
<head>
<title>Student | Welcome</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Negotiation Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css2/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css2/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="js2/jquery-2.1.4.min.js"></script>
<script src="js2/main.js"></script>
<!-- //js -->
<!-- font-awesome icons -->
<link rel="stylesheet" href="css2/font-awesome.min.css" />
<!-- //font-awesome icons -->
<link rel="stylesheet" href="css2/flexslider.css" type="text/css" media="screen" property="" />
<link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Droid+Serif:400,400i,700,700i" rel="stylesheet">
 </head>
<body>
	<div class="header">
		<div class="container">
			<nav class="navbar navbar-default">
				<div class="navbar-header navbar-left">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<%
   						Student s = new Student();
   						s.setEmail((String)session.getAttribute("email"));
   						Student s1 = StudentDao.getDetails(s);
   
   					%>
					<h1><a class="navbar-brand" href="studentWelcome.jsp"><%=s1.getRegn() %></a></h1>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
					<nav class="cl-effect-13" id="cl-effect-13">
						<ul class="nav navbar-nav">
							<li class="active"><a href="studentWelcome.jsp">Home</a></li>
							<li><a href="studentChangePassword.jsp">Change Password</a></li>
							<li><a href="cms.controller.StudentLogout">Logout</a></li>
						</ul>
					</nav>
				</div>
			</nav>
		</div>
	</div>
	</body>