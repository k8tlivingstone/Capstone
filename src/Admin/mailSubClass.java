package Admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * @Course: SDEV 435 ~ Enterprise Java Programming
 * @Author Name: Kate Livingstone
 * @Assignment Capstone
 * @Date: Mar 12, 2022
 * @Description: Email Service
 */

public class mailSubClass {

	/**
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

			}
		});
	}

	public mailSubClass() {

//		JButton jbuttonSend = new JButton("Send");
//		jbuttonSend.addActionListener((ActionListener) new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				jbuttonSend_actionPerformed(arg0);
//			}
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
	}

	private void Send_actionPerformed(ActionEvent arg0) {
		try {
//			Properties properties = new Properties();
//			properties.put("mail.smtp.auth", "true");
//			properties.put("mail.smtp.starttls.enable", "true");
//			properties.put("mail.smtp.host", "smtp.gmail.com");
//			properties.put("mail.smtp.port", "587");
//			Session session = Session.getDefaultInstance(properties, new Authenticator() {
//				@Override
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication("your gmail", "your password for gmail");
//				}
//			});

//			String address;
//			Message message = new MimeMessage(session);
//			message.setSubject("Visitor has arrived");
//			message.setContent("Dear " + recipient + ",  \n You have a visitor waiting in the lobby."
//					+ "\n Tthe Visitor's Name is: " + OrderNumber + " \n " + "\n\n Kind Regards, "
//					+ "\n Nau-Mai Administrator", "text/plain");
//			message.setFrom(new InternetAddress("kathleen.livingstone@mymail.champlain.edu"));
//			message.setRecipient(RecipientType.TO, new InternetAddress(address));
//			message.setSentDate(new Date());

//			Transport.send(message);

			JOptionPane.showMessageDialog(null, "Message Sent");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}