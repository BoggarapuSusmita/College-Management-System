<%@page import="cms.model.StudentLeaveDao"%>
<%@page import="cms.db.StudentLeave"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student | View Leave Application</title>
</head>
<style>
table, th, td {
    border: 1px solid green;
    padding: 15px;
    text-align: center;
}
table{
	top: center;
	width: 999px;
}
th{
	color: green;
	
}
img{
	height: 100px;
	width: 100px;
}
</style>
<body>
	<table>
	<thead>
		<tr>
			<th>REGISTRATION NO</th><th>NAME</th><th>EMAIL ID</th><th>FROM DATE</th><th>TO DATE</th><th>REASON</th>
			<th>STATUS</th>
		</tr>
		</thead>
		<tbody>
		<%
			
			ArrayList<StudentLeave> all = StudentLeaveDao.getStudentLeave();
			Iterator it  = all.iterator();
			while(it.hasNext())
			{
				StudentLeave t =(StudentLeave) it.next();
				%>
				
		
		<tr>
			<td><%=t.getRegn() %>
			<td><%=t.getName() %></td>
			<td><%=t.getEmail() %></td>
			<td><%=t.getFromDate() %></td>
			<td><%=t.getToDate() %></td>
			<td><%=t.getReason() %></td>
			
			<%
				if(t.getStatus()!=null)
				{
					%>
					<td>Approved</td>
					<%
				}
				else
				{
					%>
					<td>Not Approve
					</td>
			<%
				}
			%>
			
		</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>