<%@page import="java.util.Iterator"%>
<%@page import="cms.db.Student"%>
<%@page import="cms.model.StudentDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher | Take Attendence</title>
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
			<th>REGISTRATION NO</th><th>NAME</th><th>SEMESTER</th><th>BRANCH</th><th>ATTENDANCE</th>
		</tr>
		</thead>
		<tbody>
		<%
			 Student s = new Student();
			s.setDate((String)session.getAttribute("date"));
			s.setMonth((String)session.getAttribute("month"));
			s.setSemester((String)session.getAttribute("semester"));
			s.setBranch((String)session.getAttribute("branch")); 
			
			ArrayList<Student> all = StudentDao.getStudentAttendance(s);
			Iterator it  = all.iterator();
			while(it.hasNext())
			{
				Student t =(Student) it.next();
				%>
				
		
		<tr>
			<td><%=t.getRegn() %></td>
			<td><%=t.getName() %></td>
			<td><%=t.getSemester() %></td>
			<td><%=t.getBranch() %></td>
			<%
			//System.out.println(t.getDate());
				if(t.getDate()!=null)
				{
			%>
				<td style="color: green">Present</button></td>
			
			
			<%
				}
				else
				{
			%>
				
					<td style="color: red">Absent</td>
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