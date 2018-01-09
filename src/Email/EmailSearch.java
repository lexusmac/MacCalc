package Email;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSearch {

    public static void main(String[] args) throws FileNotFoundException {
        String s = "";
        String filePath = "c:\\temp2\\mails.txt";
        Scanner in = new Scanner(new File(filePath));
        while (in.hasNext())
            s += in.nextLine() + "\r\n";

        if (null != s) {
            String regex = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";
            Pattern pattern = Pattern.compile(regex);
            Matcher m = pattern.matcher(s);
            while (m.find()) {
                System.out.println(m.group());
            }
        }
    }
}
