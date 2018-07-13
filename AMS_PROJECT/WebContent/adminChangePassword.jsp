<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	String email = (String)session.getAttribute("email");
    	if(email==null)
    		response.sendRedirect("adminLogin.jsp");
    %>
    
<jsp:include page="adminChangePasswordHeader.jsp"></jsp:include>
<jsp:include page="adminChangePasswordBody.jsp"></jsp:include>
<jsp:include page="mainFooter.jsp"></jsp:include>