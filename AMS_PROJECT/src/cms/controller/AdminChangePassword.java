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
 * Servlet implementation class AdminChangePassword
 */
@WebServlet("/cms.controller.AdminChangePassword")
public class AdminChangePassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin a = new Admin();
		String opass=request.getParameter("opass");
		String npass=request.getParameter("npass");
		String cpass=request.getParameter("cpass");
		
		HttpSession session = request.getSession();
		a.setEmail((String)session.getAttribute("email"));
		a.setPassword(opass);
		
		int status = AdminDao.validate(a);
		if(status>0)
		{
			if(npass.equals(cpass))
			{
				a.setPassword(npass);
				int result = AdminDao.updatePassword(a);
				if(result>0)
					response.sendRedirect("adminChangePassword.jsp?msg=Password updated Successfully");
			}
			else
				response.sendRedirect("adminChangePassword.jsp?msg=New Password and Re-Enter Password Mismatch");
		}
		else
			response.sendRedirect("adminChangePassword.jsp?msg=Invalid Current Password");
		
	}

}
