<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	String email = (String)session.getAttribute("email");
    	if(email==null)
    		response.sendRedirect("adminLogin.jsp");
    %>
    
<head>
<title>Admin | Add Teacher</title>
</head>
<jsp:include page="adminWelcomeHeader.jsp"></jsp:include>
<jsp:include page="addTeacherBody.jsp"></jsp:include>
<jsp:include page="mainFooter.jsp"></jsp:include>