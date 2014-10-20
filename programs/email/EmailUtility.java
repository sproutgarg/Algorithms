package email;

 import java.io.ByteArrayInputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.OutputStream;
 import java.util.Date;
 import java.util.Properties;
 
 import javax.activation.DataHandler;
 import javax.activation.DataSource;
 
 import javax.mail.Message;
 import javax.mail.MessagingException;
 import javax.mail.Session;
 import javax.mail.Transport;
 import javax.mail.internet.InternetAddress;
 import javax.mail.internet.MimeMessage;
 
 public class EmailUtility {
 
 	public static boolean sendHTMLEmail (String from, String to, String cc[], String subject, String htmlText)
 	{
 		String host = "atom.corp.ebay.com";
 
 		Properties props = new Properties();
 
 		props.put("mail.smtp.host", host);
 
 		Session session = Session.getInstance(props);
 
 		try {
 			Message msg = new MimeMessage(session);
 
 			msg.setFrom(new InternetAddress(from));
 			InternetAddress[] address = {new InternetAddress(to)};
 			msg.setRecipients(Message.RecipientType.TO, address);
 			msg.setSubject(subject);
 			msg.setSentDate(new Date());
 
 			// set cc
 			if (cc != null)
 			{
 				for (int i = 0; i < cc.length; i++)
 				{
 					InternetAddress addrt = new InternetAddress(cc[i]);
 					msg.addRecipient(Message.RecipientType.CC, addrt);
 				}
 			}
 
 			msg.setDataHandler(new DataHandler(new HTMLDataSource(htmlText)));
 
 			Transport.send(msg);
 		}
 		catch (MessagingException mex) {
 			mex.printStackTrace();
 			return false;
 		}
 		catch (Exception e)
 		{
 			e.printStackTrace();
 			return false;
 		}
 		return true;
 	}
 	public static void main(String...args){
 		String from="aarumugampalanis@paypal.com";//ankugarg@paypal.com";
 		String to="aarumugampalanis@paypal.com";//"ankugarg@paypal.com";
 		String cc[] = null;
 		String subject="GOD Says";
 		String htmlText = "@@@@@@@~~~~~~~~~~!!!ENJOY WEEKEND!!!~~~~~~~~~~@@@@@@@@";
 		System.out.println("sending email:"+EmailUtility.sendHTMLEmail(from, to, cc, subject, htmlText));
 	}
 
 }
 
 class HTMLDataSource implements DataSource {
 	private String html;
 
 	public HTMLDataSource(String htmlString) {
 		html = htmlString;
 	}
 
 	public InputStream getInputStream() throws IOException {
 		if (html == null) throw new IOException("Null HTML");
 		return new ByteArrayInputStream(html.getBytes());
 	}
 
 	public OutputStream getOutputStream() throws IOException {
 		throw new IOException("This DataHandler cannot write HTML");
 	}
 
 	public String getContentType() {
 		return "text/html";
 	}
 
 	public String getName() {
 		return "JAF text/html dataSource to send e-mail only";
 	}
 }
 
