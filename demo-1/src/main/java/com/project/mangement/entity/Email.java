package com.project.mangement.entity;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public static String  sendEmail(String sendTo,String subject,String messageBody) {

		
		String to = sendTo;
		
		String from = "justgraduationproject@gmail.com";

		String host = "smtp.gmail.com";

		String password = "@Danaasma1998";

		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, password);

			}

		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(messageBody);

			System.out.println("sending...");
			// Send message
			Transport.send(message);
			
			System.out.println("Sent message successfully....");
			
			return "Sent message successfully....";
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		
		return "message not send !!";
	}
}
