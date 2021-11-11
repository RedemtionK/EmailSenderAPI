package main;

import data.FileReader;
import util.Database;
import util.Email;
import util.EmailSenderConfiguration;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SendEmail extends Database implements FileReader {
     private  static final Properties properties = new Properties();
    static {
        try {
            properties.load(SendEmail.class.getResourceAsStream("/db.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws FileNotFoundException, MessagingException, SQLException {



        FileReader fr = new SendEmail();
        String emailText = fr.emailText();

        String subject = fr.subjectText();


        EmailSenderConfiguration senderConfiguration = new EmailSenderConfiguration();
        Database db = new Database();
        db.connect(properties.getProperty("servername"),
                properties.getProperty("databaseName"),
                properties.getProperty("username"),
                properties.getProperty("password"));


        // Add emails into database
//        db.executeUpdate("INSERT INTO databaseName(COLUMN_1, COLUMN_2,..)\n" +
//        "VALUES (VALUE_1,VALUE_2,..)");
        ResultSet result = db.executeQuery("select  * from   email ");




        while(result.next()) {

            String emailFromDb = result.getString(2);
            System.out.println(emailFromDb);
            senderConfiguration.send(emailFromDb,
                    subject,
                    emailText
            );
        }


    }
}
