package cms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cms.db.Provider;
import cms.db.Student;
import cms.service.SendPassword;

public class StudentDao {

	public static int addStudent(Student t) {
		int status=0;
		String pass=SendPassword.sendStudentPassword(t);
		t.setPassword(pass);
		
		try{
			Connection con=Provider.getConnection();
			String sql ="insert into student(regn,name,fname,mname,email,religion,password,phone,address,gender,maritalstatus,qualification,branch,semester,date_of_birth) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(3, t.getFname());
			pst.setString(4, t.getMname());
			pst.setString(5, t.getEmail());
			pst.setString(6, t.getReligion());
			pst.setString(7, t.getPassword());
			pst.setString(8, t.getPhone());
			pst.setString(9, t.getAddress());
			pst.setString(10, t.getGender());
			pst.setString(11, t.getMaritalstatus());
			pst.setString(12, t.getQualification());
			pst.setString(13, t.getBranch());
			pst.setString(14, t.getSemester());
			pst.setString(15, t.getDate_of_birth());
			
			status = pst.executeUpdate();
			
			sql="insert into january(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into february(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into march(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into april(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into may(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into june(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into july(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into august(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into september(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into october(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into november(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
			
			sql="insert into december(regn,name,semester,branch) values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, t.getRegn());
			pst.setString(2, t.getName());
			pst.setString(4, t.getBranch());
			pst.setString(3, t.getSemester());
			pst.executeUpdate();
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
		return status;
	}

	public static int validate(Student a) {
		int status=0;
		try{
			Connection con=Provider.getConnection();
			String sql="select * from student where email=? and password=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, a.getEmail());
			pst.setString(2, a.getPassword());
			ResultSet rs=pst.executeQuery();
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

	public static int updatePassword(Student a) {
		int result =0;
		try 
		{
			Connection con = Provider.getConnection();
			String sql="update student set password=? where email=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(2,a.getEmail());
			pst.setString(1, a.getPassword());
			result=pst.executeUpdate();
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	public static Student getDetails(Student s){
		Student s1=null;
		try{
			Connection con=Provider.getConnection();
			String sql="select * from student where email=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getEmail());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				s1=new Student();
				s1.setName(rs.getString("name"));
				s1.setFname(rs.getString("fname"));
				s1.setMname(rs.getString("mname"));
				s1.setRegn(rs.getString("regn"));
				s1.setEmail(rs.getString("email"));
				s1.setReligion(rs.getString("religion"));
				s1.setDate_of_birth(rs.getString("date_of_birth"));
				s1.setPhone(rs.getString("phone"));
				s1.setAddress(rs.getString("address"));
				s1.setGender(rs.getString("gender"));
				s1.setMaritalstatus(rs.getString("maritalstatus"));
				s1.setQualification(rs.getString("qualification"));
				s1.setBranch(rs.getString("branch"));
				s1.setPhoto(rs.getString("photo"));
				s1.setMessage(rs.getString("message"));
				s1.setPassword(rs.getString("password"));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return s1;
	}

	public static int updatePhoto(Student s, String file_name) 
	{
		int status=0;
		try{
			Connection con=Provider.getConnection();
			String sql="update student set photo=? where email=?";
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
	
	public static ArrayList<Student> getStudent() 
	{
		ArrayList<Student> all = new ArrayList<Student>();
		try
		{
			Connection con=Provider.getConnection();
			String sql="select * from student order by regn";
			PreparedStatement pst=con.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Student t = new Student();
				t.setRegn(rs.getString("regn"));
				t.setName(rs.getString("name"));
				t.setEmail(rs.getString("email"));
				t.setPhoto(rs.getString("photo"));
				t.setSemester(rs.getString("semester"));
				all.add(t);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return all;
	}

	public static int deleteStudent(Student t) {
		int status=0;
		try
		{
			Connection con=Provider.getConnection();
			String sql="delete from student where email=?";
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
	
	public static String getPassword(Student a) 
	{
		String pass=null;
		try 
		{
			Connection con = Provider.getConnection();
			String sql="select regn,name,password from student where email=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,a.getEmail());
			

			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				a.setRegn(rs.getString(1));
				a.setName(rs.getString(2));
				pass = rs.getString(3);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return pass;
	}
	public static ArrayList<Student> getStudentAttendance(Student s) 
	{
		ArrayList<Student> all = new ArrayList<Student>();
		String date = s.getDate();
		String month= s.getMonth();
		try
		{
			Connection con=Provider.getConnection();
			String sql="select regn,name,semester,branch,"+date+" from "+month+" where branch=? and semester=? order by regn";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getBranch());
			pst.setString(2, s.getSemester());
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Student t = new Student();
				t.setRegn(rs.getString("regn"));
				t.setName(rs.getString("name"));
				t.setSemester(rs.getString("semester"));
				t.setBranch(rs.getString("branch"));
				t.setDate(rs.getString(5));
				t.setMonth(s.getMonth());
				all.add(t);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return all;
	}

	public static int updateAttendance(Student s) 
	{
		int status = 0;
		String date = s.getDate();
		String month= s.getMonth();
		try
		{
			Connection con=Provider.getConnection();
			String sql  ="update "+month+" set "+date+"='1' where semester=? and branch=? and regn=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getSemester());
			pst.setString(2, s.getBranch());
			pst.setString(3, s.getRegn());
			status = pst.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}


}
