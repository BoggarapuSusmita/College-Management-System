package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.TeacherLeave;
import cms.model.TeacherLeaveDao;

@WebServlet("/cms.controller.ApproveTeacherLeave")
public class ApproveTeacherLeave extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherLeave s = new TeacherLeave();
		s.setEmail(request.getParameter("email"));
		s.setFromDate(request.getParameter("fromdate"));
		s.setToDate(request.getParameter("todate"));
		
		int status = TeacherLeaveDao.approve(s);
		if(status>0)
			response.sendRedirect("adminViewTeacherLeave.jsp?msg=Leave Approved");
		else
			response.sendRedirect("adminViewTeacherLeave.jsp?msg=Leave not Approved");
	}


}
