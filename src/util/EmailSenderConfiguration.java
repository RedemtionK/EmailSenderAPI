package util;

import model.EmailSenderType;

import java.util.Properties;
import java.util.Set;

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



    @Override
    public void send(String to, String text) throws MessagingException {

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Email email =new Email();
        Authenticator authenticator =
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email.getMyAccountEmail(), email.getPassword());
                    }
                };

        Session session = Session.
                getDefaultInstance(properties,
                        authenticator);

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(email.getMyAccountEmail()));
        message.setRecipient(RecipientType.TO, new InternetAddress(to));

        message.setText(text);

        Transport.send(message);

        System.out.println("Mail has been sent");

    }

    @Override
    public void send(String to, String subject, String text) throws MessagingException {

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");



        Email email =new Email();
        Authenticator authenticator =
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email.getMyAccountEmail(), email.getPassword());
                    }
                };

        Session session = Session.
                getDefaultInstance(properties,
                        authenticator);

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(email.getMyAccountEmail()));
        message.setRecipient(RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(text);

        Transport.send(message);
        System.out.println("Mail has been sent");

    }

    @Override
    public void send(String to, String cc, String subject,  String text) throws MessagingException {

    }


}
