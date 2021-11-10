package model;

import javax.mail.MessagingException;
import java.util.Set;

public interface EmailSenderType {

    void send(String to, String text) throws MessagingException;
    void send(String to, String subject, String text) throws MessagingException;
    void send(String to, String cc, String subject,  String text) throws MessagingException;
    void send(Set<String> to, Set<String> cc, String subject, String text) throws MessagingException;
}
