package cms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cms.db.Provider;
import cms.db.StudentFeedback;

public class StudentFeedbackDao {

	public static int giveFeeedback(StudentFeedback s) {
		int status=0;
		try {
			Connection con=Provider.getConnection();
			String sql="insert into studentFeedback(regn,name,email,subject,message) values(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getRegn());
			pst.setString(2, s.getName());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getSubject());
			pst.setString(5, s.getMessage());
			status=pst.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static ArrayList<StudentFeedback> getStudentFeedback() {
		ArrayList<StudentFeedback> all = new ArrayList<StudentFeedback>();
		try {
			Connection con=Provider.getConnection();
			String sql="select * from StudentFeedback";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				StudentFeedback t = new StudentFeedback();
				t.setRegn(rs.getString("regn"));
				t.setName(rs.getString("name"));
				t.setEmail(rs.getString("email"));
				t.setSubject(rs.getString("subject"));
				t.setMessage(rs.getString("message"));
				all.add(t);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return all;
	}
}
