package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.Student;
import cms.model.StudentDao;

/**
 * Servlet implementation class TakeAttendance2
 */
@WebServlet("/cms.controller.TakeAttendance2")
public class TakeAttendance2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Student s = new Student();
		s.setRegn(request.getParameter("regn"));
		s.setName(request.getParameter("name"));
		s.setSemester(request.getParameter("semester"));
		s.setBranch(request.getParameter("branch"));
		s.setDate(request.getParameter("date"));
		s.setMonth(request.getParameter("month"));
		
		int status = StudentDao.updateAttendance(s);
		if(status>0)
			response.sendRedirect("teacherTakeAttendance2.jsp");
		
	}

	

}
