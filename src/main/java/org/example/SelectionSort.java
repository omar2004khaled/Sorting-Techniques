package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        if (returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

            if (returnIntermediate)
                intermediateArrays.add(Arrays.copyOf(array, array.length));
        }

        if (!returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));
        return intermediateArrays;
    }
}