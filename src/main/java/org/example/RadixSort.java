package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        if (returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        int max = Arrays.stream(array).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);

            if (returnIntermediate)
                intermediateArrays.add(Arrays.copyOf(array, array.length));
        }

        if (!returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));
        return intermediateArrays;
    }

    private static void countingSort(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];

        for (int i = 0; i < array.length; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }
}