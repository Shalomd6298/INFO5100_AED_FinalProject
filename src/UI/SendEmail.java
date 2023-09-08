/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class SendEmail {
    
    	public void sendmail(String firstname, String lastname, String to_emailID) {
            
                System.out.println("preparing to send email..");
                String to = to_emailID;
                String from = "shalom.daniel16@vit.edu";
                String host = "localhost";
                String port = "25";

                final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	 
	         Properties props = System.getProperties();
	         props.setProperty("mail.smtp.host", "smtp.gmail.com");
	         props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	         props.setProperty("mail.smtp.socketFactory.fallback", "false");
	         props.setProperty("mail.smtp.port", "465");
	         props.setProperty("mail.smtp.socketFactory.port", "465");
	         props.put("mail.smtp.auth", "true");
	         props.put("mail.debug", "true");
	         props.put("mail.store.protocol", "pop3");
	         props.put("mail.transport.protocol", "smtp");
                 
	         String usr = "";
	         String pwd = "";
                 
	         try{
	         Session session = Session.getInstance(props, 
	                              new Authenticator(){
	                                 protected PasswordAuthentication getPasswordAuthentication() {
	                                    return new PasswordAuthentication(usr, pwd);
	                                 }});
	     
	         Message msg = new MimeMessage(session);

	   
	         msg.setFrom(new InternetAddress(usr));
	         msg.setRecipients(Message.RecipientType.TO, 
	                          InternetAddress.parse(to,false));
	         msg.setSubject("Housing MGMT Customer Registeration!");
	         msg.setText("Congratulations " + firstname + " " + lastname + "! You have been successfully registered into the Housing MGMT system. You may now try logging in and browse for housing properties. \nThankyou!");
	         

	         Transport.send(msg);
	         JOptionPane.showMessageDialog(null, "Email Sent! Please verify and try logging in to the system. ");
	      }catch (MessagingException e){ }
              
        }
}
