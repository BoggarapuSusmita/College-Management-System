<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String email = (String)session.getAttribute("email");
    	if(email==null)
    		response.sendRedirect("studentLogin.jsp");
    %>
<jsp:include page="studentLoginHeader.jsp"></jsp:include>
<jsp:include page="studentForgotPasswordBody.jsp"></jsp:include>
<jsp:include page="mainFooter.jsp"></jsp:include>