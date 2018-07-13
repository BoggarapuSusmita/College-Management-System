package cms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cms.db.Provider;
import cms.db.StudentLeave;

public class StudentLeaveDao {

	public static int applyLeave(StudentLeave s) {
		int status=0;
		try{
			Connection con=Provider.getConnection();
			String sql="insert into studentLeave(regn,name,email,fromDate,toDate,reason) values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getRegn());
			pst.setString(2, s.getName());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getFromDate());
			pst.setString(5, s.getToDate());
			pst.setString(6, s.getReason());
			status=pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static ArrayList<StudentLeave> getStudentLeave() {
		ArrayList<StudentLeave> all = new ArrayList<StudentLeave>();
		try {
			Connection con=Provider.getConnection();
			String sql="select * from StudentLeave";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				StudentLeave t = new StudentLeave();
				t.setRegn(rs.getString("regn"));
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

	public static int approve(StudentLeave s) 
	{
		int status=0;
		try{
			Connection con=Provider.getConnection();
			String sql="update studentLeave set status='1' where regn=? and email=? and fromDate=? and toDate=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getRegn());
			pst.setString(2, s.getEmail());
			pst.setString(3, s.getFromDate());
			pst.setString(4, s.getToDate());
			status=pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
