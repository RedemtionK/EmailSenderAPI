package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface FileReader {

    default String emailText () throws FileNotFoundException {

       File file = new File("C:\\Users\\klaus\\Desktop\\IrisaTest.txt");
        Scanner scan = new Scanner(file);
        String text="";
        while (scan.hasNextLine()){
            text = text.concat(scan.nextLine()+"\n");
        }
        return text;
    }
}
