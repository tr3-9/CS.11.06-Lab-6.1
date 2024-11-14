import java.io.*;
import java.util.Scanner;
import java.util.*;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeTwo("testInputOneTwo.txt"));
        //all methods tested

    }

    public static int challengeOne(String filename) throws FileNotFoundException {
        List<Integer> depths = new ArrayList<>();

        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            depths.add(Integer.parseInt(scanner.nextLine().trim()));
        }
        scanner.close();

        int count = 0;
        for (int i = 1; i < depths.size(); i++) {
            if (depths.get(i) > depths.get(i - 1)) {
                count++;
            }
        }

        return count;
    }


    public static int challengeTwo(String filename) throws FileNotFoundException {
        List<Integer> depths = new ArrayList<>();

        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            depths.add(Integer.parseInt(scanner.nextLine().trim()));
        }
        scanner.close();

        int count = 0;
        for (int i = 3; i < depths.size(); i++) {
            int previousSum = depths.get(i - 3) + depths.get(i - 2) + depths.get(i - 1);
            int currentSum = depths.get(i - 2) + depths.get(i - 1) + depths.get(i); //sw
            if (currentSum > previousSum) {
                count++;
            }
        }

        return count;
    }


    public static int challengeThree(String filename) throws FileNotFoundException {
        int horizontalPosition = 0;
        int depth = 0;

        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String[] command = scanner.nextLine().split(" ");
            String direction = command[0];
            int value = Integer.parseInt(command[1]);

            if (direction.equals("forward")) {
                horizontalPosition += value;
            } else if (direction.equals("down")) {
                depth += value;
            } else if (direction.equals("up")) {
                depth -= value;
            }
        }
        scanner.close();
        return horizontalPosition * depth;
    }

    public static int challengeFour(String filename) throws FileNotFoundException {
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;

        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String[] command = scanner.nextLine().split(" ");
            String direction = command[0];
            int value = Integer.parseInt(command[1]);

            if (direction.equals("forward")) {
                horizontalPosition += value;
                depth += aim * value;   //change was added here
            } else if (direction.equals("down")) {
                aim += value;
            } else if (direction.equals("up")) {
                aim -= value;
            }
        }
        scanner.close();

        return horizontalPosition * depth;
    }


    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}