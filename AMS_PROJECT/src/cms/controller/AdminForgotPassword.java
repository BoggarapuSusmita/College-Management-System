package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.Admin;
import cms.model.AdminDao;
import cms.service.SendPassword;

/**
 * Servlet implementation class AdminForgotPassword
 */
@WebServlet("/cms.controller.AdminForgotPassword")
public class AdminForgotPassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Admin a = new Admin();
		a.setEmail(request.getParameter("email"));
		
		String pass = AdminDao.getPassword(a);
		a.setPassword(pass);
		if(pass!=null)
		{
			SendPassword.sendAdminForgotPassword(a);
			response.sendRedirect("adminForgotPassword.jsp?msg=Your Password is sent to your Mail");
		}
		else
			response.sendRedirect("adminForgotPassword.jsp?msg=Your are not registered");
	}
}
