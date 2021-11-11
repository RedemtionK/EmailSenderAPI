package data;

import util.Database;
import util.EmailSenderConfiguration;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class prova extends Database implements FileReader{
    private  static Properties properties = new Properties();

    public static void main(String[] args) throws FileNotFoundException, MessagingException, SQLException {
        try {
            properties.load(prova.class.getResourceAsStream("/db.properties"));

            //username=klaus
           // properties.getProperty("username");
        } catch (IOException e) {
            e.printStackTrace();
        }


        FileReader fr = new prova();
        String prova = fr.emailText();
        FileReader fr2 = new prova();
        String prova2 = fr.subjectText();


          EmailSenderConfiguration email = new EmailSenderConfiguration();
          Database db = new Database();
          db.connect(properties.getProperty("servername"),
                  properties.getProperty("databaseName"),
                  properties.getProperty("username"),
                  properties.getProperty("password"));


        ResultSet result = db.executeQuery("select  * from   email ");
        String emaildb="";


        while(result.next()) {
            int id = result.getInt(1);
            emaildb = result.getString(2);
            System.out.println(emaildb);
            email.send(emaildb,
                    prova2,
                    prova

            );
        }

       // System.out.println(emaildb);



//        try {
//            for (int i = 0; i < 100; i++) {
//                EmailSenderConfiguration.sendMail("ali.altjon@gmail.com ",
//                        "Prova",
//                        prova
//                        );
//                System.out.println("U dergua email!");
//                Thread.sleep(2000);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(prova);
 }
}
