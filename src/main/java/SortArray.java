package main.java;

import main.java.algorithms.*;

public class SortArray {
    private int[] array;

    // Constructor
    public SortArray(int[] array) {
        this.array = array;
    }

    // Simple Sort (Insertion Sort)
    public int[][] simpleSort(boolean returnIntermediate) {
        return InsertionSort.sort(array, returnIntermediate);
    }

    // Efficient Sort (Merge Sort)
    public int[][] efficientSort(boolean returnIntermediate) {
        return MergeSort.sort(array, returnIntermediate);
    }

    // Non-Comparison Sort (Radix Sort)
    public int[][] nonComparisonSort(boolean returnIntermediate) {
        return RadixSort.sort(array, returnIntermediate);
    }

    // Getter for the array
    public int[] getArray() {
        return array;
    }
}