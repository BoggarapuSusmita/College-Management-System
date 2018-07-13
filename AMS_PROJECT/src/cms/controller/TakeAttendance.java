package cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TakeAttendance
 */
@WebServlet("/cms.controller.TakeAttendance")
public class TakeAttendance extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String date = request.getParameter("date");
		String month = request.getParameter("month");
		String semester = request.getParameter("semester");
		String branch = request.getParameter("branch");
		
		session.setAttribute("date", date);
		session.setAttribute("month", month);
		session.setAttribute("semester", semester);
		session.setAttribute("branch", branch);
		
		response.sendRedirect("teacherTakeAttendance2.jsp");
	}

}
