package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.Teacher;
import cms.model.TeacherDao;

/**
 * Servlet implementation class DeleteTeacher
 */
@WebServlet("/cms.controller.DeleteTeacher")
public class DeleteTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		Teacher t = new Teacher();
		t.setEmail(email);
		int status = TeacherDao.deleteTeacher(t);
		if(status>0)
		{
			response.sendRedirect("adminViewTeacher.jsp?msg=Deletion Successful");
		}
		else
			response.sendRedirect("adminViewTeacher.jsp?msg=Error in Deletion");
	}

	

}
