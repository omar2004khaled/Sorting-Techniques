package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the input file: ");
        String filePath = scanner.nextLine();

        try {
            int[] array = readArrayFromFile(filePath);
            SortArray sortArray = new SortArray(array);
            System.out.println("Array initialized successfully!");

            while (true) {
                System.out.println("\nMain Menu:");
                System.out.println("1. Simple Sort (Insertion Sort - O(n²))");
                System.out.println("2. Efficient Sort (Merge Sort - O(n log n))");
                System.out.println("3. Non-Comparison Sort (Radix Sort - O(n))");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                if (choice == 4)
                    break;

                System.out.print("Return intermediate arrays? (true/false): ");
                boolean returnIntermediate = scanner.nextBoolean();

                int[][] result;
                switch (choice) {
                    case 1:
                        result = sortArray.simpleSort(returnIntermediate);
                        break;
                    case 2:
                        result = sortArray.efficientSort(returnIntermediate);
                        break;
                    case 3:
                        result = sortArray.nonComparisonSort(returnIntermediate);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        continue;
                }

                System.out.println("Result:");
                for (int[] arr : result) {
                    System.out.println(Arrays.toString(arr));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static int[] readArrayFromFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        String[] elements = scanner.nextLine().split(",");
        int[] array = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }
        scanner.close();
        return array;
    }
}