import java.util.*;
import java.io.*;

// Henadzi Kirykovich CS 210
// 5/19/2025
// Description: Read input from file if user selects major CS/Math/Physics

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner promt = new Scanner(System.in);
        String myChoice;
        boolean isValid = true;

        do {
            System.out.print("Input major (CS/Math/Physics): ");
            myChoice = promt.next();

            if (myChoice.equals("CS") || myChoice.equals("Math") || myChoice.equals("Physics")) {
                Scanner inputFile = new Scanner(new File("C:\\Users\\annak\\Dropbox\\PC\\Desktop\\CS210\\QQQ\\major.txt")); // Re-open file every loop
                String name, gender, major;
                int age;
                int counter = 0;
                double sum = 0;
                String fullNameMajor = null;

                System.out.printf("%-10s %-10s %-10s\n", "Name", "Age", "Major");
                System.out.println("--------------------------------");

                while (inputFile.hasNext()) {
                    name = inputFile.next();
                    gender = inputFile.next();
                    age = inputFile.nextInt();
                    major = inputFile.next();

                    if (major.equals(myChoice)) {
                        counter++;
                        sum += age;
                        System.out.printf("%-10s %-10d %-10s\n", name, age, major);
                    }
                }

                inputFile.close();
                if (counter > 0) {
                    System.out.println();
                    System.out.printf("There are %d %s students.\n", counter, myChoice);
                    System.out.printf("Average age: %4.1f\n", sum / counter);
                } else {
                    System.out.println("No students found for this major.");
                }

                isValid = false; // end loop if valid
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        } while (isValid);
    }
}
