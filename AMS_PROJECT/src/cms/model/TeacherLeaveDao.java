package cms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import cms.db.Provider;
import cms.db.TeacherLeave;

public class TeacherLeaveDao {

	public static int applyLeave(TeacherLeave s) {
		int status=0;
		try{
			Connection con=Provider.getConnection();
			String sql="insert into teacherLeave(name,email,fromDate,toDate,reason) values(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getEmail());
			pst.setString(3, s.getFromDate());
			pst.setString(4, s.getToDate());
			pst.setString(5, s.getReason());
			status=pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static ArrayList<TeacherLeave> getTeacherLeave() {
		ArrayList<TeacherLeave> all = new ArrayList<TeacherLeave>();
		try {
			Connection con=Provider.getConnection();
			String sql="select * from TeacherLeave";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TeacherLeave t = new TeacherLeave();
				t.setName(rs.getString("name"));
				t.setEmail(rs.getString("email"));
				t.setFromDate(rs.getString("fromDate"));
				t.setToDate(rs.getString("toDate"));
				t.setReason(rs.getString("reason"));
				t.setStatus(rs.getString("status"));
				all.add(t);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return all;
	}
	
	public static int approve(TeacherLeave s) 
	{
		int status=0;
		try{
			Connection con=Provider.getConnection();
			String sql="update TeacherLeave set status='1' where email=? and fromDate=? and toDate=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			pst.setString(2, s.getFromDate());
			pst.setString(3, s.getToDate());
			status=pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
