package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.Teacher;
import cms.model.TeacherDao;

/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/cms.controller.AddTeacher")
public class AddTeacher extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Teacher t = new Teacher();
		t.setName(request.getParameter("name"));
		t.setEmail(request.getParameter("email"));
		t.setSpecialization(request.getParameter("specialization"));
		t.setDepartment(request.getParameter("department"));
		t.setQualification(request.getParameter("qulification"));
		t.setPermanentAddress(request.getParameter("permanentAddress"));
		t.setPresentAddress(request.getParameter("presentAddress"));
		t.setCity(request.getParameter("city"));
		t.setDistrict(request.getParameter("district"));
		t.setPincode(request.getParameter("pincode"));
		t.setState(request.getParameter("state"));
		t.setGender(request.getParameter("gender"));
		t.setMaritalStatus(request.getParameter("maritalStatus"));
		t.setMobile_No(request.getParameter("mobile_no"));
		
		int status=TeacherDao.addTeacher(t);
		if(status>0)
		{
			response.sendRedirect("addTeacher.jsp?msg=Registration Success");
		}
		else
			response.sendRedirect("addTeacher.jsp?msg=Error in Registration");
	}

}
