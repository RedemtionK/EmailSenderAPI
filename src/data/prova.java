package data;

import util.Database;
import util.EmailSenderConfiguration;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class prova extends Database implements FileReader{

    public static void main(String[] args) throws FileNotFoundException, MessagingException, SQLException {
        FileReader fr = new prova();
          String prova = fr.emailText();

          EmailSenderConfiguration email = new EmailSenderConfiguration();
          Database db = new Database();
          db.connect("localhost",
                  "myemailapi",
                  "klaus",
                  "klaus");

        ResultSet result = db.executeQuery("select  * from   email where Id = 3");
        String emaildb="";
        while(result.next()) {
            int id = result.getInt(1);
            emaildb = result.getString(2);
        }

        System.out.println(emaildb);
       while (true) {
           email.send(emaildb,
                   prova

           );
       }
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
