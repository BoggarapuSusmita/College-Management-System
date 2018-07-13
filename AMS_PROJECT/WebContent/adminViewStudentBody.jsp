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
<title>Admin | View Student</title>
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
i{
	color: green;
}

i:HOVER {
	color: #4CAF50;
}
</style>
<body>
	<table>
	<thead>
		<tr>
			<th>REGISTRATION NO</th><th>NAME</th><th>EMAIL ID</th><th>PHOTO</th><th>DELETE</th>
		</tr>
		</thead>
		<tbody>
		<%
			
			ArrayList<Student> all = StudentDao.getStudent();
			Iterator it  = all.iterator();
			while(it.hasNext())
			{
				Student t =(Student) it.next();
				%>
				
		
		<tr>
			<td><%=t.getRegn() %></td>
			<td><%=t.getName() %></td>
			<td><%=t.getEmail() %></td>
			<% 
  								String photo_name=t.getPhoto();
  							
  								if(photo_name == null)
  								{
  							%>
  									<td><img src="profileimg/b2.jpg" ></td>
  							<%
  								}
  								else
  								{
  									//String p1 = "profileimg\\";
  									String p2 = t.getPhoto();
  								
  							%>
 								<td><img src=<%=p2 %> style="height: 100px; width: 100px;"></td> 								
  							<%
  								}
  							%>
			
			<td><a href="cms.controller.DeleteStudent?email=<%=t.getEmail()%>"><i style="font-size: 40px" class="fa fa-trash"></i></a></td>
			
		</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>