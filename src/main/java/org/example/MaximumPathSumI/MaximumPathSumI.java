package org.example.MaximumPathSumI;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximumPathSumI {
    private static String readFile(File file) throws FileNotFoundException, IOException, Exception {
        StringBuilder content = new StringBuilder();
        String lineFile = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((lineFile = bufferedReader.readLine()) != null){
            content.append(lineFile);
            content.append(System.lineSeparator());
        }
        bufferedReader.close();

        return content.toString();
    }

    private static int[][] converFileNumberToArray(File file) throws FileNotFoundException, IOException, Exception{
        if (!file.exists()){
            throw new FileNotFoundException("File " + file.getAbsolutePath() + " not exists");
        }

        int i = countLines(file);

        int[][] numbers = new int[i][];

        String file1 = readFile(file);

        String[] strings = file1.split(System.lineSeparator());

        for (int counter = 0; counter < strings.length; counter++) {
            String[] strings2 = strings[counter].split(" ");
            numbers[counter]= new int[strings2.length];

            for (int counter2 = 0; counter2 < numbers[counter].length; counter2++) {

                numbers[counter][counter2] = Integer.parseInt(strings2[counter2]);
            }

        }

        return numbers;
    }

    public static int maximumPathSumI(File file) throws FileNotFoundException, IOException, Exception {
        int[][] numberToArray = converFileNumberToArray(file);
        int sum = 0;
        for (int counter1 = numberToArray.length - 2; counter1 >= 0 ; counter1--) {

            for (int counter2 = 0; counter2 <= counter1; counter2++) {

                numberToArray[counter1][counter2] += maximumNumber(numberToArray[counter1 + 1][counter2], numberToArray[counter1 + 1][counter2 + 1]);
                sum = numberToArray[counter1][counter2];

            }

        }

        return sum;
    }

    private static int maximumNumber(int... numbers) {
        int number = 0;

        for (int counter = 0; counter < numbers.length; counter++) {
            number = numbers[counter] > number ? numbers[counter] : number;
        }

        return number;
    }

    private static int countLines(File file) throws FileNotFoundException, IOException, Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        int size = bufferedReader.lines().toList().size();

        bufferedReader.close();

        return size;
    }
}
