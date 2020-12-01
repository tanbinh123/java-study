package common;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailContentSend {
	private String SMPT_HOSTNAME;
	private String USERNAME;
	private String PASSWORD;	
	
	public void setMail(String host, String user,String password) {
		this.SMPT_HOSTNAME = host;
		this.USERNAME = user;
		this.PASSWORD = password;
	}
	public void sendMail(String fromMailAddr,String toMailAddr,
			String title, String content,String attachImg) throws Exception{
	   Properties props = new Properties();
	   props.put("mail.smtp.host", SMPT_HOSTNAME);
	   props.put("mail.from",fromMailAddr);
	   props.put("mail.smtp.port", "587");//465 587
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.auth", "true");
	   //props.put("mail.debug", "true");

	   Session session = Session.getInstance(props, new Authenticator() {
		   @Override
		   protected PasswordAuthentication getPasswordAuthentication() {
			   return new PasswordAuthentication(USERNAME, PASSWORD);
		   }
	   });
	   try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom();
			msg.setRecipients(Message.RecipientType.TO,toMailAddr);
			msg.setSubject(title);
			msg.setSentDate(new Date());
			   
			MimeMultipart multipart = new MimeMultipart("related");


			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "";
//				if(!attachImg.equals("")) htmlText +="<img src=\"cid:image\">";
			htmlText += content;
			
			messageBodyPart.setContent(htmlText, "text/html;charset=UTF-8");
			// add it
			multipart.addBodyPart(messageBodyPart);

		
		// second part (the image)
			if(!attachImg.equals("")) {
				messageBodyPart = new MimeBodyPart();
	//			DataSource fds = new FileDataSource("C:\\Temp\\bu_01_over.jpg");
				DataSource fds = new FileDataSource(attachImg);
				messageBodyPart.setDataHandler(new DataHandler(fds));
				messageBodyPart.setHeader("Content-ID","<image>");
				
				// add it
				multipart.addBodyPart(messageBodyPart);	           
			}	
			msg.setContent(multipart);
			Transport.send(msg);
		} catch (MessagingException mex) {
			System.out.println("send failed, exception: " + mex);
		}
		
	}
	
}
