package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.model.StudentLeaveDao;
import cms.db.StudentLeave;

@WebServlet("/cms.controller.StudentApplyLeave")
public class StudentApplyLeave extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentLeave s = new StudentLeave();
		s.setRegn(request.getParameter("regn"));
		s.setName(request.getParameter("name"));
		s.setEmail(request.getParameter("email"));
		s.setFromDate(request.getParameter("fromDate"));
		s.setToDate(request.getParameter("toDate"));
		s.setReason(request.getParameter("reason"));
		
		int status=StudentLeaveDao.applyLeave(s);
		if(status>0)
		{
			response.sendRedirect("studentWelcome.jsp");
		}
		else
			response.sendRedirect("studentLeave.jsp?msg=Error in submission");
	}
}
