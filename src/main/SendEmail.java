package main;

import data.FileReader;
import util.Database;
import util.EmailSenderConfiguration;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SendEmail extends Database implements FileReader {
    private  static Properties properties = new Properties();

    public static void main(String[] args) throws FileNotFoundException, MessagingException, SQLException {
        try {
            properties.load(SendEmail.class.getResourceAsStream("/db.properties"));

            //username=klaus
            // properties.getProperty("username");
        } catch (IOException e) {
            e.printStackTrace();
        }


        FileReader fr = new SendEmail();
        String emailText = fr.emailText();
        FileReader fr2 = new SendEmail();
        String subject = fr.subjectText();


        EmailSenderConfiguration email = new EmailSenderConfiguration();
        Database db = new Database();
        db.connect(properties.getProperty("servername"),
                properties.getProperty("databaseName"),
                properties.getProperty("username"),
                properties.getProperty("password"));


        ResultSet result = db.executeQuery("select  * from   email ");
        String emailFromDb="";


        while(result.next()) {

            emailFromDb = result.getString(2);
            System.out.println(emailFromDb);
            email.send(emailFromDb,
                    subject,
                    emailText
            );
        }


    }
}
