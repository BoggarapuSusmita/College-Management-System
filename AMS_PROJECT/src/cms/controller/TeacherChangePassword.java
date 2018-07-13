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
 * Servlet implementation class TeacherChangePassword
 */
@WebServlet("/cms.controller.TeacherChangePassword")
public class TeacherChangePassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher a = new Teacher();
		String opass=request.getParameter("opass");
		String npass=request.getParameter("npass");
		String cpass=request.getParameter("cpass");
		
		HttpSession session = request.getSession();
		a.setEmail((String)session.getAttribute("email"));
		a.setPassword(opass);
		
		int status = TeacherDao.validate(a);
		if(status>0)
		{
			if(npass.equals(cpass))
			{
				a.setPassword(npass);
				int result = TeacherDao.updatePassword(a);
				if(result>0)
					response.sendRedirect("teacherChangePassword.jsp?msg=Password updated Successfully");
			}
			else
				response.sendRedirect("teacherChangePassword.jsp?msg=New Password and Re-Enter Password Mismatch");
		}
		else
			response.sendRedirect("studentChangePassword.jsp?msg=Invalid Current Password");
		
	}

}
