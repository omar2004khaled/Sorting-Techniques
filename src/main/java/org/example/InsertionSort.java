package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        if (returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;

            if (returnIntermediate)
                intermediateArrays.add(Arrays.copyOf(array, array.length));
        }

        if (!returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));
        return intermediateArrays;
    }
}