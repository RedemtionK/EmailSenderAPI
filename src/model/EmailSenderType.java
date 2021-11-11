package model;

import javax.mail.MessagingException;


public interface EmailSenderType {
    // whithout subject
    void send(String to, String text) throws MessagingException;

    //whith subject
    void send(String to, String subject, String text) throws MessagingException;


}
