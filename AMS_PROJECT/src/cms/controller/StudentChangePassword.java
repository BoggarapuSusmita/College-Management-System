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


@WebServlet("/cms.controller.StudentChangePassword")
public class StudentChangePassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student a = new Student();
		String opass=request.getParameter("opass");
		String npass=request.getParameter("npass");
		String cpass=request.getParameter("cpass");
		
		HttpSession session = request.getSession();
		a.setEmail((String)session.getAttribute("email"));
		a.setPassword(opass);
		
		int status = StudentDao.validate(a);
		if(status>0)
		{
			if(npass.equals(cpass))
			{
				a.setPassword(npass);
				int result = StudentDao.updatePassword(a);
				if(result>0)
					response.sendRedirect("studentChangePassword.jsp?msg=Password updated Successfully");
			}
			else
				response.sendRedirect("studentChangePassword.jsp?msg=New Password and Re-Enter Password Mismatch");
		}
		else
			response.sendRedirect("studentChangePassword.jsp?msg=Invalid Current Password");
		
	}

}
