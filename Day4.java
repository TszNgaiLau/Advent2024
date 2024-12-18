

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/InputFile");

        // build a 2D Array based on the length of each string and the size of the list
        // e.g
        // ABCD
        // EFGH
        // IJKL
        // This would be a 3 row, 4 column 2D array
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        int totalMatches = 0;
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
            }
        }

//        checkHorizontal(grid) + checkVertical(grid) + checkDiagonalRight(grid) +
        totalMatches = checkHorizontal(grid) + checkVertical(grid) + checkDiagonalRight(grid) +checkDiagonalLeft(grid);
        System.out.println(totalMatches);



        // "grid" represents a 2D array of Strings built from the input file
    }

    public static int checkHorizontal(String[][] Hor) {
        int matches = 0;
        for (int r = 0; r < Hor.length; r++) {
            for (int c = 0; c < Hor[0].length - 3; c++) {
                if (Hor[r][c].equals("X") && Hor[r][c + 1].equals("M") && Hor[r][c + 2].equals("A") && Hor[r][c + 3].equals("S")) {
                    matches++;
                    System.out.println("Hor1");
                }
                if (Hor[r][c].equals("S") && Hor[r][c + 1].equals("A") && Hor[r][c + 2].equals("M") && Hor[r][c + 3].equals("X")) {
                    matches++;
                    System.out.println("Hor2");
                }
            }
        }
        return matches;
    }

    public static int checkVertical(String[][] Hor) {
        int matches = 0;
        for (int c = 0; c < Hor[0].length; c++) {
            for (int r = 0; r < Hor.length - 3; r++) {
                if (Hor[r][c].equals("X") && Hor[r + 1][c].equals("M") && Hor[r + 2][c].equals("A") && Hor[r + 3][c].equals("S")) {
                    matches++;
                    System.out.println("ver1");
                }
                if (Hor[r][c].equals("S") && Hor[r + 1][c].equals("A") && Hor[r + 2][c].equals("M") && Hor[r + 3][c].equals("X")) {
                    matches++;
                    System.out.println("ver2");
                }
            }
        }
        return matches;
    }

    public static int checkDiagonalLeft(String[][] Hor) {
        int matches = 0;
        for (int c = 0; c < Hor[0].length - 3; c++) {
            for (int r = 0; r < Hor.length - 3; r++) {
                if (Hor[r][c].equals("X") && Hor[r + 1][c + 1].equals("M") && Hor[r + 2][c + 2].equals("A") && Hor[r + 3][c + 3].equals("S")) {
                    matches++;
                    System.out.println("diag1l");
                }
                if (Hor[r][c].equals("S") && Hor[r + 1][c + 1].equals("A") && Hor[r + 2][c + 2].equals("M") && Hor[r + 3][c + 3].equals("X")) {
                    matches++;
                    System.out.println("diag2l");
                }
            }
        }
        return matches;
    }

    public static int checkDiagonalRight(String[][] Hor) {
        int matches = 0;
        for (int r = 0; r < Hor.length - 3; r++) {
            for (int c = Hor[0].length - 1; c >= 3; c--) {
                System.out.println("here");
                System.out.println(r + " " + c);
                if (Hor[r][c].equals("X") && Hor[r + 1][c - 1].equals("M") && Hor[r + 2][c - 2].equals("A") && Hor[r + 3][c - 3].equals("S")) {
                    matches++;
                    System.out.println("diag1r");
                }
                if (Hor[r][c].equals("S") && Hor[r + 1][c - 1].equals("A") && Hor[r + 2][c - 2].equals("M") && Hor[r + 3][c - 3].equals("X")) {
                    matches++;
                    System.out.println("diag2r");
                }
            }
        }
        return matches;
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
