package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        if (returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (returnIntermediate)
                intermediateArrays.add(Arrays.copyOf(array, array.length));
        }

        if (!returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));
        return intermediateArrays;
    }
}