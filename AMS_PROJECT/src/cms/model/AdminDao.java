package cms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cms.db.Admin;
import cms.db.Provider;

public class AdminDao {

	public static int validate(Admin a) 
	{
		int status = 0;
		try 
		{
			Connection con = Provider.getConnection();
			String sql="select * from admin where email=? and password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,a.getEmail());
			pst.setString(2, a.getPassword());

			ResultSet rs = pst.executeQuery();
			if(rs.next())
				status=1;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	public static int updatePassword(Admin a) 
	{
		int result =0;
		try 
		{
			Connection con = Provider.getConnection();
			String sql="update admin set password=? where email=?";
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

	public static String getPassword(Admin a) 
	{
		String pass=null;
		try 
		{
			Connection con = Provider.getConnection();
			String sql="select password from admin where email=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,a.getEmail());
			

			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				
				pass = rs.getString(1);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return pass;
	}

}
