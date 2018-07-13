package cms.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.*;

import cms.db.Admin;
import cms.db.Student;
import cms.db.Teacher;

public class SendPassword {

	public static String sendTeacherPassword(Teacher t) 
	{
		
		String to=t.getEmail();
		String subject="OTP Sent";
		char[] msg1=otp_ForTeacher(5);
		String otp1=String.valueOf(msg1);
		/*String otp2=t.getEmail().substring(0,3)+otp1;*/
		String message = "Dear Teacher Please Login Using "+t.getEmail()+"& password is:"+otp1;
		
		String from="lit.lab.project@gmail.com";
		String password="litproject2018";
		
		try 
		{
			//Authentication with Gmail server
			Properties props=new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			
			Authenticator auth = new Authenticator() 
			{
				public PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication(from, password);
				}
			};
			
			Session session = Session.getInstance(props, auth);
			
			//Composing the message
			MimeMessage msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(message);
			
			//Sending message
			Transport.send(msg);
			System.out.println("Message delivered successfully , Check your mail ...........");
			//response.sendRedirect("mail.jsp?msg=mail delivered");
		} 
		catch (MessagingException e) 
		{
			// TODO: handle exception
			//throw new RuntimeException(e);
			e.printStackTrace();
		}
		return otp1;
	}
	private static char[] otp_ForTeacher(int len) {
		
		System.out.println("Generating OTP using random():");
		System.out.println("Your new OTP is:");
		
		String numbers="123456789";
		Random r=new Random();
		char[] otp=new char[len];
		
		for(int i=0;i<len;i++)
		{
			otp[i]=numbers.charAt(r.nextInt(numbers.length()));
		}
	
		return otp;
	}
	public static String sendStudentPassword(Student t) 
	{
		
		String to=t.getEmail();
		String subject="OTP Sent";
		char[] msg1=otp_ForTeacher(5);
		String otp1=String.valueOf(msg1);
		/*String otp2=t.getEmail().substring(0,3)+otp1;*/
		String message = "Dear Teacher Please Login Using "+t.getEmail()+"& password is:"+otp1;
		
		String from="lit.lab.project@gmail.com";
		String password="litproject2018";
		
		try 
		{
			//Authentication with Gmail server
			Properties props=new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			
			Authenticator auth = new Authenticator() 
			{
				public PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication(from, password);
				}
			};
			
			Session session = Session.getInstance(props, auth);
			
			//Composing the message
			MimeMessage msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(message);
			
			//Sending message
			Transport.send(msg);
			System.out.println("Message delivered successfully , Check your mail ...........");
			//response.sendRedirect("mail.jsp?msg=mail delivered");
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
		return otp1;
	}
	public static void sendTeacherForgotPassword(Teacher a) 
	{
		String to=a.getEmail();
		String subject="Password Sent";
		String message="Hello "+a.getName()+" your Password is : "+a.getPassword();
		
		String from="lit.lab.project@gmail.com";
		String password="litproject2018"; 
		
		try {
			//Authentication with Gmail server
			Properties props=new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			
			Authenticator auth = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			};
			
			Session session = Session.getInstance(props, auth);
			
			//Composing the message
			MimeMessage msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(message);
			
			//Sending message
			Transport.send(msg);
			System.out.println("Message delivered successfully , Check your mail ...........");
			//response.sendRedirect("mail.jsp?msg=mail delivered");
		} catch (MessagingException e) {
			// TODO: handle exception
			//throw new RuntimeException(e);
			e.printStackTrace();
		}
	}
	public static void sendAdminForgotPassword(Admin a) {
		String to=a.getEmail();
		String subject="Password Sent";
		String message="Hello Admin your Password is : "+a.getPassword();
		
		String from="lit.lab.project@gmail.com";
		String password="litproject2018"; 
		
		try {
			//Authentication with Gmail server
			Properties props=new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			
			Authenticator auth = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			};
			
			Session session = Session.getInstance(props, auth);
			
			//Composing the message
			MimeMessage msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(message);
			
			//Sending message
			Transport.send(msg);
			System.out.println("Message delivered successfully , Check your mail ...........");
			//response.sendRedirect("mail.jsp?msg=mail delivered");
		} catch (MessagingException e) {
			// TODO: handle exception
			//throw new RuntimeException(e);
			e.printStackTrace();
		}
	}
	public static void sendStudentForgotPassword(Student a) {
		String to=a.getEmail();
		String subject="Password Sent";
		String message="Hello "+a.getName()+"your registration no is"+a.getRegn()+" and your Password is : "+a.getPassword();
		
		String from="lit.lab.project@gmail.com";
		String password="litproject2018"; 
		
		try {
			//Authentication with Gmail server
			Properties props=new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			
			Authenticator auth = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			};
			
			Session session = Session.getInstance(props, auth);
			
			//Composing the message
			MimeMessage msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(message);
			
			//Sending message
			Transport.send(msg);
			System.out.println("Message delivered successfully , Check your mail ...........");
			//response.sendRedirect("mail.jsp?msg=mail delivered");
		} catch (MessagingException e) {
			// TODO: handle exception
			//throw new RuntimeException(e);
			e.printStackTrace();
		}
	}
}
