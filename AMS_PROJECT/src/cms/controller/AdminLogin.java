package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cms.db.Admin;
import cms.model.AdminDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/cms.controller.AdminLogin")
public class AdminLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Admin a = new Admin();
		a.setEmail(request.getParameter("email"));
		a.setPassword(request.getParameter("password"));
		
		int status= AdminDao.validate(a);
		if(status>0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", a.getEmail());
			response.sendRedirect("adminWelcome.jsp");
		}
		else
			response.sendRedirect("adminLogin.jsp?msg=Invalid Email or Password");
	}

}
