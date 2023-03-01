import java.util.Random;
import java.util.Scanner;

public class Main {

    // Random bound value.
    private static final int BOUND = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students ids in the given database: ");

        try {
            // Stores the user input.
            int noOfStudents = Integer.parseInt(scanner.nextLine());

            // Checks if user entered 0 or a negative number.
            if (noOfStudents <= 0) {
                System.out.println("Enter a whole number greater than 0.");
                return;
            }

            // Forming Database of student ids.
            int[] studentIdDatabase = getRandomIntegerArray(noOfStudents);

            // Print student database.
            System.out.println("\nStudent ids:");
            printDatabase(studentIdDatabase);

            // Prints duplicate students.
            System.out.println("\nDuplicate student id:");
            findDuplicates(studentIdDatabase);
        } catch (NumberFormatException e) {
            System.out.println("\nPlease enter a whole number.");
        }
    }

    /**
     * Prints duplicate values in the array.
     *
     * @param database Contains student ids.
     */
    private static void findDuplicates(int[] database) {
        // Stores the number of times a value in database is repeated.
        int[] count;

        // Initializing count.
        if (database.length > BOUND) {
            count = new int[database.length];
        } else {
            count = new int[BOUND];
        }

        // Finds and prints duplicates.
        for (int value : database) {
            count[value]++;
            if (count[value] == 2) {
                System.out.print(value + " ");
            }
        }
    }

    /**
     * Prints the contents of student id array.
     *
     * @param database Integer array.
     */
    private static void printDatabase(int[] database) {
        for (int i : database) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Creates an integer array filled up random integers from 1 to 99.
     *
     * @param size Size of the array.
     * @return Integer array containing random integers.
     */
    private static int[] getRandomIntegerArray(int size) {
        int[] array = new int[size];

        // Finds a random number.
        Random random = new Random();

        // Filling up the array with random integers.
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(0, BOUND);
        }
        return array;
    }
}
