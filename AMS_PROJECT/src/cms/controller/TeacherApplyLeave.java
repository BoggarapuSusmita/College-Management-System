package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.TeacherLeave;
import cms.model.TeacherLeaveDao;

@WebServlet("/cms.controller.TeacherApplyLeave")
public class TeacherApplyLeave extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherLeave s = new TeacherLeave();
		s.setName(request.getParameter("name"));
		s.setEmail(request.getParameter("email"));
		s.setFromDate(request.getParameter("fromDate"));
		s.setToDate(request.getParameter("toDate"));
		s.setReason(request.getParameter("reason"));
		
		int status=TeacherLeaveDao.applyLeave(s);
		if(status>0)
		{
			response.sendRedirect("teacherWelcome.jsp");
		}
		else
			response.sendRedirect("teacherApplyLeave.jsp?msg=Error in submission");
	}
}
