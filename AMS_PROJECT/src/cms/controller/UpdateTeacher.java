package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cms.db.Teacher;
import cms.model.TeacherDao;

@WebServlet("/cms.controller.UpdateTeacher")
public class UpdateTeacher extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		Teacher t = new Teacher();
		t.setEmail((String)session.getAttribute("email"));
		//t.setEmail(request.getParameter("email"));
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
		
		int status=TeacherDao.updateTeacher(t);
		if(status>0)
		{
			response.sendRedirect("teacherWelcome.jsp?msg=Updated Successfully");
		}
		else
			response.sendRedirect("teacherEditProfile.jsp?msg=Error in Updation");
	}

}
