package util;

import model.EmailSenderType;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSenderConfiguration implements EmailSenderType {
    private  static final Properties properties = new Properties();
    static {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
    }
    private static final Email email = new Email();
// Configure email
    static {
        email.setMyAccountEmail("email@gmail.com");
        email.setPassword("password");
    }
    private static final Authenticator authenticator =
            new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email.getMyAccountEmail(), email.getPassword());
                }
            };
    private static final Session session = Session.
            getDefaultInstance(properties,
                    authenticator);
    private static final Message message = new MimeMessage(session);


//without subject
    @Override
    public void send(String to, String text) throws MessagingException {

        message.setFrom(new InternetAddress(email.getMyAccountEmail()));
        message.setRecipient(RecipientType.TO, new InternetAddress(to));
        message.setText(text);
        Transport.send(message);
        System.out.println("Mail has been sent");

    }
    // with subject
    @Override
    public void send(String to, String subject, String text) throws MessagingException {
        message.setFrom(new InternetAddress(email.getMyAccountEmail()));
        message.setRecipient(RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(text);
        Transport.send(message);
        System.out.println("Mail has been sent");

    }



}
