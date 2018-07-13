package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.StudentFeedback;
import cms.model.StudentFeedbackDao;

@WebServlet("/cms.controller.StudentGiveFeedback")
public class StudentGiveFeedback extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentFeedback s = new StudentFeedback();
		s.setRegn(request.getParameter("regn"));
		s.setName(request.getParameter("name"));
		s.setEmail(request.getParameter("email"));
		s.setSubject(request.getParameter("subject"));
		s.setMessage(request.getParameter("message"));
		
		int status=StudentFeedbackDao.giveFeeedback(s);
		if(status>0)
			response.sendRedirect("studentWelcome.jsp");
		else
			response.sendRedirect("studentFeedback.jsp?msg=Error in Submission");
	}
}
