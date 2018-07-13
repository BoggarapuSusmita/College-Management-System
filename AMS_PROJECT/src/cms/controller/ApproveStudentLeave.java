package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.StudentLeave;
import cms.model.StudentLeaveDao;

/**
 * Servlet implementation class ApproveStudentLeave
 */
@WebServlet("/cms.controller.ApproveStudentLeave")
public class ApproveStudentLeave extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentLeave s = new StudentLeave();
		s.setRegn(request.getParameter("regn"));
		s.setEmail(request.getParameter("email"));
		s.setFromDate(request.getParameter("fromdate"));
		s.setToDate(request.getParameter("todate"));
		
		int status = StudentLeaveDao.approve(s);
		if(status>0)
			response.sendRedirect("adminViewStudentLeave.jsp?msg=Leave Approved");
		else
			response.sendRedirect("adminViewStudentLeave.jsp?msg=Leave not Approved");
	}


}
