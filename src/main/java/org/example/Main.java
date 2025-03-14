package main.java.org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(BOLD + BLUE + "Enter the path of the input file: " + RESET);
            String filePath = scanner.nextLine();

            try {
                int[] array = readArrayFromFile(filePath);
                SortArray sortArray = new SortArray(array);
                System.out.println(GREEN + "Array initialized successfully!" + RESET);

                while (true) {
                    System.out.println("\n" + UNDERLINE + BOLD + CYAN + " Main Menu " + RESET);
                    System.out.println(YELLOW + "1." + RESET + " Simple Sort (O(n²))");
                    System.out.println(YELLOW + "2." + RESET + " Efficient Sort (O(n log n))");
                    System.out.println(YELLOW + "3." + RESET + " Non-Comparison Sort (O(n))");
                    System.out.println(YELLOW + "4." + RESET + " Exit");
                    System.out.print(BOLD + "Choose an option: " + RESET);
                    
                    int choice = scanner.nextInt();
                    while (choice > 4 || choice < 1) {
                        System.out.print(RED + "Invalid option! Please enter (1,2,3,4): " + RESET);
                        choice = scanner.nextInt();
                    }

                    if (choice == 4) {
                        System.out.println(BOLD + CYAN + "Exiting the program..." + RESET);
                        break;
                    }

                    String algorithm = "";
                    switch (choice) {
                        case 1:
                            System.out.println("\n" + UNDERLINE + "Simple Sort Algorithms:" + RESET);
                            System.out.println("1. Insertion Sort");
                            System.out.println("2. Selection Sort");
                            System.out.println("3. Bubble Sort");
                            System.out.print(BOLD + "Choose an algorithm: " + RESET);
                            int simpleChoice = scanner.nextInt();
                            while (simpleChoice > 3 || simpleChoice < 1) {
                                System.out.print(RED + "Invalid option! Choose (1,2,3): " + RESET);
                                simpleChoice = scanner.nextInt();
                            }
                            algorithm = switch (simpleChoice) {
                                case 1 -> "InsertionSort";
                                case 2 -> "SelectionSort";
                                case 3 -> "BubbleSort";
                                default -> "";
                            };
                            break;

                        case 2:
                            System.out.println("\n" + UNDERLINE + "Efficient Sort Algorithms:" + RESET);
                            System.out.println("1. Merge Sort");
                            System.out.println("2. Quick Sort");
                            System.out.print(BOLD + "Choose an algorithm: " + RESET);
                            int efficientChoice = scanner.nextInt();
                            while (efficientChoice > 2 || efficientChoice < 1) {
                                System.out.print(RED + "Invalid option! Choose (1,2): " + RESET);
                                efficientChoice = scanner.nextInt();
                            }
                            algorithm = (efficientChoice == 1) ? "MergeSort" : "QuickSort";
                            break;

                        case 3:
                            System.out.println("\n" + UNDERLINE + "Non-Comparison Sort Algorithms:" + RESET);
                            System.out.println("1. Radix Sort");
                            System.out.println("2. Counting Sort");
                            System.out.print(BOLD + "Choose an algorithm: " + RESET);
                            int nonComparisonChoice = scanner.nextInt();
                            while (nonComparisonChoice > 2 || nonComparisonChoice < 1) {
                                System.out.print(RED + "Invalid option! Choose (1,2): " + RESET);
                                nonComparisonChoice = scanner.nextInt();
                            }
                            algorithm = (nonComparisonChoice == 1) ? "RadixSort" : "CountingSort";
                            break;
                    }

                    System.out.print(BOLD + "Return intermediate arrays? (y/n): " + RESET);
                    char temp = scanner.next().charAt(0);
                    while (temp != 'y' && temp != 'n') {
                        System.out.print(RED + "Invalid input! Please enter (y/n): " + RESET);
                        temp = scanner.next().charAt(0);
                    }
                    boolean returnIntermediate = (temp == 'y');

                    long start = System.nanoTime();
                    ArrayList<int[]> result = new ArrayList<>();
                    switch (choice) {
                        case 1 -> result = sortArray.simpleSort(returnIntermediate, algorithm);
                        case 2 -> result = sortArray.efficientSort(returnIntermediate, algorithm);
                        case 3 -> result = sortArray.nonComparisonSort(returnIntermediate, algorithm);
                    }
                    long finish = System.nanoTime();
                    long timeElapsed = (finish - start) / 1000;

                    System.out.println("\n" + UNDERLINE + BOLD + "Sorted Result:" + RESET);
                    if (returnIntermediate) {
                        System.out.println(CYAN + "Intermediate arrays:" + RESET);
                        for (int[] arr : result) {
                            System.out.println(Arrays.toString(arr));
                        }
                        System.out.println(GREEN + "Final sorted array: " + RESET);
                        System.out.println(Arrays.toString(result.get(result.size() - 1)));
                    } else {
                        System.out.println(GREEN + "Final sorted array: " + RESET);
                        System.out.println(Arrays.toString(result.get(0)));
                    }
                    System.out.println(BLUE + "Time Taken = " + timeElapsed + " µs" + RESET);
                    System.out.println(BOLD + "============================" + RESET);
                }
            } catch (FileNotFoundException e) {
                System.out.println(RED + "Error: File not found!" + RESET);
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
