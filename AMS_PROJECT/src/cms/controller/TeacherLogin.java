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

/**
 * Servlet implementation class TeacherLogin
 */
@WebServlet("/cms.controller.TeachertLogin")
public class TeacherLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Teacher a = new Teacher();
		a.setEmail(request.getParameter("email"));
		a.setPassword(request.getParameter("password"));
		
		int status= TeacherDao.validate(a);
		if(status>0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", a.getEmail());
			response.sendRedirect("teacherWelcome.jsp");
		}
		else
			response.sendRedirect("teacherLogin.jsp?msg=Invalid Email or Password");
	}

}
