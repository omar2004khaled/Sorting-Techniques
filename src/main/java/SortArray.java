package main.java;

import main.java.algorithms.*;

public class SortArray {
    private int[] array;

    public SortArray(int[] array) {
        this.array = array;
    }

    public int[][]simpleSort(boolean returnIntermediate) {
        return InsertionSort.sort(array, returnIntermediate);
    }

    public int[][] efficientSort(boolean returnIntermediate) {
        return MergeSort.sort(array, returnIntermediate);
    }

    public int[][] nonComparisonSort(boolean returnIntermediate) {
        return RadixSort.sort(array, returnIntermediate);
    }

    public int[] getArray() {
        return array;
    }
}