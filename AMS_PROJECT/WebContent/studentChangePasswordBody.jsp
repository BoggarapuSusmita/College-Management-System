<head>
	<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Course Registration Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Meta tag Keywords -->
<link href="css3/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<!-- //js -->
<!-- web-fonts -->
<link href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
<!-- //web-fonts --> 
</head>
<body>
	<!-- banner --> 
<div class="video"> 
	<div class="center-container">
	    <div class="w3ls-agileinfo">
			<h1> Change Passowrd </h1>	
		</div>
		 <div class="bg-agile">
		<font color="white"><%
		 	String msg = request.getParameter("msg");
		 	if(msg!=null)
		 		out.println(msg);
		 
		 %></font> 
			<div class="login-form">	
				<form action="cms.controller.StudentChangePassword" method="post">
					<input type="text"  name="opass" placeholder="Current Password" required="" />
					<input type="text"  name="npass" placeholder="New Password" required="" />
					<input type="text" name="cpass" placeholder="Re-enter Password" required="" />
					<input type="submit" value="Submit">
				</form>	
			</div>	
		</div>
	<!-- //banner --> 
	</div>	
</div>
</body>