package main.java.org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the path of the input file: ");
            String filePath = scanner.nextLine();

            try {
                int[] array = readArrayFromFile(filePath);
                SortArray sortArray = new SortArray(array);
                System.out.println("Array initialized successfully!");

                while (true) {
                    System.out.println("\nMain Menu:");
                    System.out.println("1. Simple Sort (O(n²))");
                    System.out.println("2. Efficient Sort (O(n log n))");
                    System.out.println("3. Non-Comparison Sort (O(n))");
                    System.out.println("4. Exit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    while (choice > 4 || choice < 1) {
                        System.out.print("\u001B[31mPlease enter valid option (1,2,3,4): \u001B[0m");
                        choice = scanner.nextInt();
                    }

                    if (choice == 4)
                        break;

                    String algorithm = "";
                    switch (choice) {
                        case 1:
                            System.out.println("Choose a simple sort algorithm:");
                            System.out.println("1. Insertion Sort");
                            System.out.println("2. Selection Sort");
                            System.out.println("3. Bubble Sort");
                            System.out.print("Choose an algorithm: ");
                            int simpleChoice = scanner.nextInt();
                            while (simpleChoice > 3 || simpleChoice < 1) {
                                System.out.print("\u001B[31mPlease enter valid option (1,2,3): \u001B[0m");
                                simpleChoice = scanner.nextInt();
                            }
                            switch (simpleChoice) {
                                case 1:
                                    algorithm = "InsertionSort";
                                    break;
                                case 2:
                                    algorithm = "SelectionSort";
                                    break;
                                case 3:
                                    algorithm = "BubbleSort";
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Choose an efficient sort algorithm:");
                            System.out.println("1. Merge Sort");
                            System.out.println("2. Quick Sort");
                            System.out.print("Choose an algorithm: ");
                            int efficientChoice = scanner.nextInt();
                            while (efficientChoice > 2 || efficientChoice < 1) {
                                System.out.print("\u001B[31mPlease enter valid option (1,2): \u001B[0m");
                                efficientChoice = scanner.nextInt();
                            }
                            switch (efficientChoice) {
                                case 1:
                                    algorithm = "MergeSort";
                                    break;
                                case 2:
                                    algorithm = "QuickSort";
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("Choose a non-comparison sort algorithm:");
                            System.out.println("1. Radix Sort");
                            System.out.println("2. Counting Sort");
                            System.out.print("Choose an algorithm: ");
                            int nonComparisonChoice = scanner.nextInt();
                            while (nonComparisonChoice > 2 || nonComparisonChoice < 1) {
                                System.out.print("\u001B[31mPlease enter valid option (1,2): \u001B[0m");
                                nonComparisonChoice = scanner.nextInt();
                            }
                            switch (nonComparisonChoice) {
                                case 1:
                                    algorithm = "RadixSort";
                                    break;
                                case 2:
                                    algorithm = "CountingSort";
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            continue;
                    }

                    System.out.print("Return intermediate arrays? (y/n): ");
                    char temp = scanner.next().charAt(0);
                    while (temp != 'y' && temp != 'n') {
                        System.out.print("\u001B[31mPlease enter valid option (y/n): \u001B[0m");
                        temp = scanner.next().charAt(0);
                    }
                    boolean returnIntermediate = temp == 'y';

                    long start = System.nanoTime();
                    ArrayList<int[]> result = new ArrayList<>();
                    switch (choice) {
                        case 1:
                            result = sortArray.simpleSort(returnIntermediate, algorithm);
                            break;
                        case 2:
                            result = sortArray.efficientSort(returnIntermediate, algorithm);
                            break;
                        case 3:
                            result = sortArray.nonComparisonSort(returnIntermediate, algorithm);
                            break;
                    }
                    long finish = System.nanoTime();
                    long TimeElapsed = (finish - start) / 1000;

                    if (returnIntermediate) {
                        System.out.println("Intermediate arrays:");
                        for (int[] arr : result)
                            System.out.println(Arrays.toString(arr));
                        System.out.println("Final sorted array :");
                        System.out.println(Arrays.toString(result.get(result.size() - 1)));
                    } else {
                        System.out.println("Final sorted array :");
                        System.out.println(Arrays.toString(result.get(0)));
                    }
                    System.out.println("\u001B[34mTime Taken = " + TimeElapsed + " µs\u001B[0m");
                    System.out.println("============================");
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        }
    }

    private static int[] readArrayFromFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        String line = scanner.nextLine().trim();
        String[] elements = line.split(","); // ignore commas
        int[] array = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i].trim()); // ignore spaces
        }
        scanner.close();
        return array;
    }
}