<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin | Forgot Password</title>
<link href="css1/font-awesome.css" rel="stylesheet"><!-- Font-awesome-CSS --> 
<link href="css1/style.css" rel='stylesheet' type='text/css'/><!-- style.css --> 
<link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Basic Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<script src="js1/jquery.min.js"></script>
		<script>$(document).ready(function(c) {
		$('.alert-close').on('click', function(c){
			$('.main-agile').fadeOut('slow', function(c){
				$('.main-agile').remove();
			});
		});	  
	});
	</script>
</head>
<body>
	<div class="main-agile">
		<div class="alert-close"> </div>
		<div class="content-wthree">
		<div class="circle-w3layouts"></div>
			<h2>Forgot Password</h2>
			<form action="cms.controller.AdminForgotPassword" method="post">
				<div class="inputs-w3ls">
					<i class="fa fa-user" aria-hidden="true"></i>
					<input type="text" name="email" placeholder="Username" required=""/>
				</div>
				
				<font color="white"><%
		 			String msg = request.getParameter("msg");
		 			if(msg!=null)
		 				out.println(msg);
		 
		 		%></font> 
					<input type="submit" value="SUBMIT"> 
			</form>
		</div>
	</div>
</body>
</html>