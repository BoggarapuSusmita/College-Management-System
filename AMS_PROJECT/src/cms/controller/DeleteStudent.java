package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.Student;
import cms.model.StudentDao;

@WebServlet("/cms.controller.DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		Student t = new Student();
		t.setEmail(email);
		int status = StudentDao.deleteStudent(t);
		if(status>0)
		{
			response.sendRedirect("adminViewStudent.jsp?msg=Deletion Successful");
		}
		else
			response.sendRedirect("adminViewStudent.jsp?msg=Error in Deletion");
	}

	

}
