package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArray {
    private int[] array;
    private int[] originalArray; // Store the original array

    public SortArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        this.originalArray = Arrays.copyOf(array, array.length); // Store a copy of the original array
    }

    // Reset the array to its original state before sorting
    private void resetArray() {
        this.array = Arrays.copyOf(originalArray, originalArray.length);
    }

    public ArrayList<int[]> simpleSort(boolean returnIntermediate, String algorithm) {
        resetArray(); // Reset the array before sorting
        switch (algorithm) {
            case "InsertionSort":
                return InsertionSort.sort(array, returnIntermediate);
            case "SelectionSort":
                return SelectionSort.sort(array, returnIntermediate);
            case "BubbleSort":
                return BubbleSort.sort(array, returnIntermediate);
            default:
                throw new IllegalArgumentException("Invalid simple sort algorithm");
        }
    }

    public ArrayList<int[]> efficientSort(boolean returnIntermediate, String algorithm) {
        resetArray(); // Reset the array before sorting
        switch (algorithm) {
            case "MergeSort":
                return MergeSort.sort(array, returnIntermediate);
            case "QuickSort":
                return QuickSort.sort(array, returnIntermediate);
            default:
                throw new IllegalArgumentException("Invalid efficient sort algorithm");
        }
    }

    public ArrayList<int[]> nonComparisonSort(boolean returnIntermediate, String algorithm) {
        resetArray(); // Reset the array before sorting
        switch (algorithm) {
            case "RadixSort":
                return RadixSort.sort(array, returnIntermediate);
            case "CountingSort":
                return CountingSort.sort(array, returnIntermediate);
            default:
                throw new IllegalArgumentException("Invalid non-comparison sort algorithm");
        }
    }
}