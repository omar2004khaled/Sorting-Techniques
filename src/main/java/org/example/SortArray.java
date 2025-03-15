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
        return InsertionSort.sort(array, returnIntermediate);
            
        }
    

    // Efficient Sort: O(n log n) algorithms
    public ArrayList<int[]> efficientSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        return MergeSort.sort(array, returnIntermediate);
           
    }

    // Non-Comparison Sort: O(n) algorithms
    public ArrayList<int[]> nonComparisonSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        return RadixSort.sort(array, returnIntermediate);
           
    }
}