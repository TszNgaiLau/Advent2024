import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/input");

        int total = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String[] split = fileData.get(i).split(" ");
            int curr = Integer.parseInt(split[0]);
            int next = Integer.parseInt(split[1]);
            boolean increase = false;
            if (curr < next) {
                increase = true;
            }
            int times = 0;
            boolean firstTime = true;
            for (int j = 0; j < split.length - 1; j++) {
                curr = Integer.parseInt(split[j]);
                next = Integer.parseInt(split[j+1]);
                if (increase && Math.abs(curr - next) <= 3 && curr < next) {
                    times++;
                } else if (!increase && Math.abs(curr - next) <= 3 && curr > next) {
                    times++;
                } else if (firstTime) {
                    firstTime = false;
                    split[j+1] = String.valueOf(curr);
                    times++;
                    curr = Integer.parseInt(split[j]);
                    next = Integer.parseInt(split[j+1]);
                    if (curr < next) {
                        increase = true;
                    } else {
                        increase = false;
                    }
                    System.out.println(Arrays.toString(split));
                }
                if (times == split.length - 1) {
                    total++;
                }
            }
        }
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