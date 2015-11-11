package email;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

	private static String HOST = "smtp.gmail.com";
	private static String USER = "ankur.bmv@gmail.com";
	private static String PASSWORD = "";
	private static String PORT = "465";
	private static String FROM = "ankur.bmv@gmail.com";
	private static String TO = "jskfreerunner@gmail.com";

	private static String STARTTLS = "true";
	private static String AUTH = "true";
	private static String DEBUG = "true";
	private static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private static String SUBJECT = "Regarding the Consultation Paper about regulation of OTTs";
	private static String TEXT = "This is a test message from my java application.<br/> Just ignore it";

	public static boolean sendHTMLEmail(String from, String to, String cc[],
			String subject, String htmlText) {
		String host = "smtp.gmail.com";

		Properties props = new Properties();

        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.user", USER);
        props.put("mail.smtp.password", PASSWORD);
 
        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.starttls.enable", STARTTLS);
        props.put("mail.smtp.debug", DEBUG);
 
        props.put("mail.smtp.socketFactory.port", PORT);
        props.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
 
		Session session = Session.getInstance(props);

		try {
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());

			// set cc
			if (cc != null) {
				for (int i = 0; i < cc.length; i++) {
					InternetAddress addrt = new InternetAddress(cc[i]);
					msg.addRecipient(Message.RecipientType.CC, addrt);
				}
			}

			msg.setDataHandler(new DataHandler(new HTMLDataSource(htmlText)));
			  Transport transport = session.getTransport("smtp");
	            transport.connect(HOST, USER, PASSWORD);
	            transport.sendMessage(msg, msg.getAllRecipients());
	            transport.close();
			Transport.send(msg);
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String from = "ankugarg@paypal.com";// ankugarg@paypal.com";
		String to = "ankugarg@paypal.com";// "ankugarg@paypal.com";
		String cc[] = null;
		String subject = "@@@@@@@~~~~~~~~~~!!!EMAIL OVERFLOW!!!~~~~~~~~~~@@@@@@@@";
//		String htmlText = loadMessageBody().toString();
//		System.out.println(htmlText);
		
		System.out.println("sending email:"+EmailUtility.sendHTMLEmail(from, to, cc, subject, TEXT));
		// int N = 9;
		// for(int i = 0; i< N; i++){
		// System.out.println("sending email:"+EmailUtility.sendHTMLEmail(from,
		// to, cc, subject, htmlText));
		// }

	}

	public static StringBuffer loadMessageBody() {
		StringBuffer msg = new StringBuffer();
		try (BufferedReader reader = new BufferedReader(
				new FileReader(
						new File(
								"c:\\Users\\ankugarg\\workspace-luna\\Algorithms\\emails\\message_body")));) {
			String buffer;
			while ((buffer = reader.readLine()) != null) {
				msg.append(buffer + "\n");
			}
			reader.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}

}

class HTMLDataSource implements DataSource {
	private String html;

	public HTMLDataSource(String htmlString) {
		html = htmlString;
	}

	public InputStream getInputStream() throws IOException {
		if (html == null)
			throw new IOException("Null HTML");
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
