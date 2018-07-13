package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cms.db.Student;
import cms.model.StudentDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/cms.controller.StudentLogin")
public class StudentLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Student a = new Student();
		a.setEmail(request.getParameter("email"));
		a.setPassword(request.getParameter("password"));
		
		int status= StudentDao.validate(a);
		if(status>0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", a.getEmail());
			response.sendRedirect("studentWelcome.jsp");
		}
		else
			response.sendRedirect("studentLogin.jsp?msg=Invalid Email or Password");
	}

}
