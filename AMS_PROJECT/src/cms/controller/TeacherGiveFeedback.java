package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.db.TeacherFeedback;
import cms.model.TeacherFeedbackDao;

@WebServlet("/cms.controller.TeacherGiveFeedback")
public class TeacherGiveFeedback extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherFeedback t=new TeacherFeedback();
		t.setName(request.getParameter("name"));
		t.setEmail(request.getParameter("email"));
		t.setSubject(request.getParameter("subject"));
		t.setMessage(request.getParameter("message"));
		
		int status=TeacherFeedbackDao.giveFeedback(t);
		
		if(status>0)
			response.sendRedirect("teacherWelcome.jsp");
		else
			response.sendRedirect("teacherGiveFeedback.jsp?msg=Error in Submission");
	}

}
