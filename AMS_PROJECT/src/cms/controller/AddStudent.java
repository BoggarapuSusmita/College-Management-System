package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cms.db.Student;
import cms.model.StudentDao;


/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/cms.controller.AddStudent")
public class AddStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Student t = new Student();
		t.setName(request.getParameter("name"));
		t.setEmail(request.getParameter("email"));
		t.setRegn(request.getParameter("regn"));
		t.setFname(request.getParameter("fname"));
		t.setMname(request.getParameter("mname"));
		t.setReligion(request.getParameter("religion"));
		t.setPhone(request.getParameter("phone"));
		t.setAddress(request.getParameter("address"));
		t.setGender(request.getParameter("gender"));
		t.setQualification(request.getParameter("qualification"));
		t.setBranch(request.getParameter("branch"));
		t.setSemester(request.getParameter("semester"));
		t.setDate_of_birth(request.getParameter("date_of_birth"));
		t.setMaritalstatus(request.getParameter("maritalStatus"));
		
		int status=StudentDao.addStudent(t);
		if(status>0)
		{
			response.sendRedirect("addStudent.jsp?msg=Registration Success");
		}
		else
			response.sendRedirect("addStudent.jsp?msg=Error in Registration");
	}

}
