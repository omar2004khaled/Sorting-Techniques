package main.java;

import main.java.algorithms.*;
import java.util.ArrayList;

public class SortArray {
    private int[] array;

    public SortArray(int[] array) {
        this.array = array;
    }

    public ArrayList<int[]> simpleSort(boolean returnIntermediate) {
        return InsertionSort.sort(array, returnIntermediate);
    }

    public ArrayList<int[]> efficientSort(boolean returnIntermediate) {
        return MergeSort.sort(array, returnIntermediate);
    }

    public ArrayList<int[]> nonComparisonSort(boolean returnIntermediate) {
        return RadixSort.sort(array, returnIntermediate);
    }

    public int[] getArray() {
        return array;
    }
}