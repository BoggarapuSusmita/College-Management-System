package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.Student;
import cms.model.StudentDao;
import cms.service.SendPassword;

@WebServlet("/cms.controller.StudentForgotPassword")
public class StudentForgotPassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Student a = new Student();
		a.setEmail(request.getParameter("email"));
		
		String pass = StudentDao.getPassword(a);
		a.setPassword(pass);
		if(pass!=null)
		{
			SendPassword.sendStudentForgotPassword(a);
			response.sendRedirect("studentForgotPassword.jsp?msg=Your Password is sent to your Mail");
		}
		else
			response.sendRedirect("studentForgotPassword.jsp?msg=Your are not registered");
	}
}
