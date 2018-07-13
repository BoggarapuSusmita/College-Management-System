package cms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cms.db.Provider;
import cms.db.Teacher;
import cms.service.SendPassword;

public class TeacherDao {

	public static int addTeacher(Teacher t) {
		int status=0;
		String pass=SendPassword.sendTeacherPassword(t);
		t.setPassword(pass);
		
		try{
			Connection con=Provider.getConnection();
			String sql =" insert into teacher(name,email,Specialization,PresentAddress ,PermanentAddress ,Gender ,MaritalStatus ,City, Department , Qualification ,District ,State ,Pincode,Mobile_No,password ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setString(2, t.getEmail());
			pst.setString(3, t.getSpecialization());
			pst.setString(4, t.getPresentAddress());
			pst.setString(5, t.getPermanentAddress());
			pst.setString(6, t.getGender());
			pst.setString(7, t.getMaritalStatus());
			pst.setString(8, t.getCity());
			pst.setString(9, t.getDepartment());
			pst.setString(10, t.getQualification());
			pst.setString(11, t.getDistrict());
			pst.setString(12, t.getState());
			pst.setString(13, t.getPincode());
			pst.setString(14, t.getMobile_No());
			pst.setString(15, t.getPassword());
			
			status = pst.executeUpdate();
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
		return status;
	}

	public static int validate(Teacher a) {
		int status=0;
		try{
			Connection con=Provider.getConnection();
			String sql="select * from teacher where email=? and password=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, a.getEmail());
			pst.setString(2, a.getPassword());
			ResultSet rs= pst.executeQuery();
			if(rs.next()){
				status=1;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			return status;
	}

	public static int updatePassword(Teacher a) {
		int status=0;
		try{
			Connection con=Provider.getConnection();
			String sql="update teacher set password=? where email=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(2, a.getEmail());
			pst.setString(1, a.getPassword());
			status=pst.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	public static Teacher getDetails(Teacher s){
		Teacher s1=null;
		try{
			Connection con=Provider.getConnection();
			String sql="select * from teacher where email=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				s1=new Teacher();
				s1.setName(rs.getString("name"));
				s1.setDistrict(rs.getString("district"));
				s1.setState(rs.getString("state"));
				s1.setPincode(rs.getString("pincode"));
				s1.setEmail(rs.getString("email"));
				s1.setDepartment(rs.getString("department"));
				s1.setCity(rs.getString("city"));
				s1.setMobile_No(rs.getString("mobile_no"));
				s1.setPresentAddress(rs.getString("presentaddress"));
				s1.setGender(rs.getString("gender"));
				s1.setMaritalStatus(rs.getString("maritalstatus"));
				s1.setQualification(rs.getString("qualification"));
				s1.setSpecialization(rs.getString("specialization"));
				s1.setPhoto(rs.getString("photo"));
				s1.setMessage(rs.getString("message"));
				s1.setPassword(rs.getString("password"));
				s1.setPermanentAddress(rs.getString("permanentaddress"));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return s1;
	}

	public static int updateTeacher(Teacher t) {
		int status=0;
		
		try{
			Connection con=Provider.getConnection();
			String sql =" update teacher set Specialization=?,PresentAddress=? ,PermanentAddress=? ,Gender=? ,MaritalStatus=? ,City=?, Department=? , Qualification=? ,District=? ,State=? ,Pincode=?,Mobile_No=? where email=?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(13, t.getEmail());
			pst.setString(1, t.getSpecialization());
			pst.setString(2, t.getPresentAddress());
			pst.setString(3, t.getPermanentAddress());
			pst.setString(4, t.getGender());
			pst.setString(5, t.getMaritalStatus());
			pst.setString(6, t.getCity());
			pst.setString(7, t.getDepartment());
			pst.setString(8, t.getQualification());
			pst.setString(9, t.getDistrict());
			pst.setString(10, t.getState());
			pst.setString(11, t.getPincode());
			pst.setString(12, t.getMobile_No());
			
			status = pst.executeUpdate();
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
		return status;
	}

	public static int updatePhoto(Teacher s, String file_name) 
	{
		int status=0;
		try{
			Connection con=Provider.getConnection();
			String sql="update teacher set photo=? where email=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getPhoto());
			pst.setString(2, s.getEmail());
			status=pst.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static ArrayList<Teacher> getTeachers() 
	{
		ArrayList<Teacher > all = new ArrayList<Teacher>();
		try
		{
			Connection con=Provider.getConnection();
			String sql="select * from teacher order by name";
			PreparedStatement pst=con.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Teacher t = new Teacher();
				t.setName(rs.getString("name"));
				t.setEmail(rs.getString("email"));
				t.setPhoto(rs.getString("photo"));
				all.add(t);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return all;
	}

	public static int deleteTeacher(Teacher t) {
		int status=0;
		try
		{
			Connection con=Provider.getConnection();
			String sql="delete from teacher where email=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, t.getEmail());
			status=pst.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	public static String getPassword(Teacher a) {
		String pass=null;
		try 
		{
			Connection con = Provider.getConnection();
			String sql="select name,password from teacher where email=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,a.getEmail());
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				a.setName(rs.getString(1));
				pass = rs.getString(2);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return pass;
	}
	
		

}
