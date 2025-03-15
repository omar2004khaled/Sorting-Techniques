package main.java.org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    private int[] array;
    private int[] originalArray; // Store the original array

    // Constructor: Reads the array from a file
    public SortArray(String filePath) throws FileNotFoundException {
        this.array = readArrayFromFile(filePath);
        this.originalArray = Arrays.copyOf(array, array.length); // Store a copy of the original array
    }

    public SortArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        this.originalArray = Arrays.copyOf(array, array.length); // Store a copy of the original array
    }

    // Helper method to read an array from a file
    private int[] readArrayFromFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        String line = scanner.nextLine().trim();
        String[] elements = line.split(","); // Split by commas
        int[] array = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i].trim()); // Convert to integers
        }
        scanner.close();
        return array;
    }

    // Reset the array to its original state before sorting
    private void resetArray() {
        this.array = Arrays.copyOf(originalArray, originalArray.length);
    }

    // Simple Sort: O(n²) algorithms
    public ArrayList<int[]> simpleSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "Simple Sort Algorithms:");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Bubble Sort");
        System.out.print("Choose an algorithm: ");
        int choice = scanner.nextInt();
        while (choice > 3 || choice < 1) {
            System.out.print("Invalid option! Choose (1,2,3): ");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                return InsertionSort.sort(array, returnIntermediate);
            case 2:
                return SelectionSort.sort(array, returnIntermediate);
            case 3:
                return BubbleSort.sort(array, returnIntermediate);
            default:
                throw new IllegalArgumentException("Invalid simple sort algorithm");
        }
    }

    // Efficient Sort: O(n log n) algorithms
    public ArrayList<int[]> efficientSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "Efficient Sort Algorithms:");
        System.out.println("1. Merge Sort");
        System.out.println("2. Quick Sort");
        System.out.print("Choose an algorithm: ");
        int choice = scanner.nextInt();
        while (choice > 2 || choice < 1) {
            System.out.print("Invalid option! Choose (1,2): ");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                return MergeSort.sort(array, returnIntermediate);
            case 2:
                return QuickSort.sort(array, returnIntermediate);
            default:
                throw new IllegalArgumentException("Invalid efficient sort algorithm");
        }
    }

    // Non-Comparison Sort: O(n) algorithms
    public ArrayList<int[]> nonComparisonSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "Non-Comparison Sort Algorithms:");
        System.out.println("1. Radix Sort");
        System.out.println("2. Counting Sort");
        System.out.print("Choose an algorithm: ");
        int choice = scanner.nextInt();
        while (choice > 2 || choice < 1) {
            System.out.print("Invalid option! Choose (1,2): ");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                return RadixSort.sort(array, returnIntermediate);
            case 2:
                return CountingSort.sort(array, returnIntermediate);
            default:
                throw new IllegalArgumentException("Invalid non-comparison sort algorithm");
        }
    }
}