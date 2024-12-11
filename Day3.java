
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day3 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/input");
        ArrayList<String> allMatches = new ArrayList<String>();

        StringBuilder str = new StringBuilder();
        for (String ma : fileData) {
            str.append(ma);
        }

        String regex = "mul\\([1-9]{1,3},[1-9]{1,3}\\)";
        Matcher m = Pattern.compile(regex).matcher(str);
        while (m.find()) {
            allMatches.add(m.group(0));
        }
        for (String curr : allMatches) {
            int num1 = Integer.parseInt(curr.substring(4, curr.indexOf(",")));
            int num2 = Integer.parseInt(curr.substring(curr.indexOf(",") + 1, curr.indexOf(")")));
        }

    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}