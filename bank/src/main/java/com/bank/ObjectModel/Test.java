package com.bank.ObjectModel;


import java.net.Authenticator;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;







public class Test {

	public static void main(String[] args) {
		
		String str="rahul";
		
		String[] split = str.split(" ");
		
		System.out.println(split[1]);
		
//		String message=" preparing to send massage";
//		String subject= "prowings";
//		String to="mayuridaksh05@gmail.com";
//		String from="krushnadaksh55@gmail.com";
//		
//		
//		sentEmail(message, subject, to, from);

	}
	
	
	public static void sentEmail( String massage,String sub,String to,String from) {
		String host="smtp.gmail.com";
		String password="Csp5504#";
		Properties properties = System.getProperties();
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		
		Session instance = Session.getInstance(properties, new javax.mail.Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication( password, "karm");
			}
		
			
		
		}) ;
		
		
		instance.setDebug(true);
		
		MimeMessage m = new MimeMessage(instance);
		
		try {
			m.setFrom(from);
			
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			m.setSubject(sub);
			
			m.setText(massage);
			
			
			Transport.send(m);
			
			System.out.println("Massage sent sucssfully................!");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
