package cms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cms.db.Provider;
import cms.db.TeacherFeedback;

public class TeacherFeedbackDao {

	public static int giveFeedback(TeacherFeedback t) {
		int status=0;
		try {
			Connection con=Provider.getConnection();
			String sql="insert into teacherFeedback(name,email,subject,message) values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setString(2, t.getEmail());
			pst.setString(3, t.getSubject());
			pst.setString(4, t.getMessage());
			status=pst.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static ArrayList<TeacherFeedback> getTeachersFeedback() {
		ArrayList<TeacherFeedback> all = new ArrayList<TeacherFeedback>();
		try {
			Connection con=Provider.getConnection();
			String sql="select * from teacherFeedback";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TeacherFeedback t = new TeacherFeedback();
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
