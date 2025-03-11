package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingSort {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        if (returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }

        if (returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        if (!returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));
        return intermediateArrays;
    }
}