
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Collections;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/input");
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();

        for (String num : fileData) {
            String[] split = num.split(" {3}");
            firstList.add(Integer.parseInt(split[0]));
            secondList.add(Integer.parseInt(split[1]));
        }

        int total = 0;
        int sim = 0;
        Collections.sort(firstList);
        Collections.sort(secondList);

        for (int i = 0; i < firstList.size(); i++) {
            total += Math.abs(firstList.get(i) - secondList.get(i));
        }

        for (int i = 0; i < firstList.size(); i++) {
            int times = 0;
            for (int j = 0; j < secondList.size(); j++) {
                if (Objects.equals(firstList.get(i), secondList.get(j))) {
                    times++;
                }
            }
            sim += firstList.get(i) * times;
        }
        System.out.println(sim);
        System.out.println(total);
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
