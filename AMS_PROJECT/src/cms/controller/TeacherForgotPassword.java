package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.Teacher;
import cms.model.TeacherDao;
import cms.service.SendPassword;

@WebServlet("/cms.controller.TeacherForgotPassword")
public class TeacherForgotPassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Teacher a = new Teacher();
		a.setEmail(request.getParameter("email"));
		
		String pass = TeacherDao.getPassword(a);
		a.setPassword(pass);
		if(pass!=null)
		{
			SendPassword.sendTeacherForgotPassword(a);
			response.sendRedirect("teacherForgotPassword.jsp?msg=Your Password is sent to your Mail");
		}
		else
			response.sendRedirect("teacherForgotPassword.jsp?msg=Your are not registered");
	}
}
