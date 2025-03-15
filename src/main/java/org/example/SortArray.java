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
    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
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
    private void resetArray() {
        this.array = Arrays.copyOf(originalArray, originalArray.length);
    }

    public ArrayList<int[]> InsertionSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        return InsertionSort.sort(array, returnIntermediate);    
        }
    public ArrayList<int[]> SelectionSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        return SelectionSort.sort(array, returnIntermediate);    
        }
    public ArrayList<int[]> BubbleSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        return BubbleSort.sort(array, returnIntermediate);    
        }
    public ArrayList<int[]> MergeSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        return MergeSort.sort(array, returnIntermediate);
           
    }
    public ArrayList<int[]> QuickSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        return QuickSort.sort(array, returnIntermediate);
           
    }
    public ArrayList<int[]> RadixSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        return RadixSort.sort(array, returnIntermediate);
           
    }
    public ArrayList<int[]> CountingSort(boolean returnIntermediate) {
        resetArray(); // Reset the array before sorting
        return CountingSort.sort(array, returnIntermediate);     
    }
}