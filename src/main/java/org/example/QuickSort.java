package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        if (returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        quickSort(array, 0, array.length - 1, intermediateArrays, returnIntermediate);

        if (!returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));
        return intermediateArrays;
    }

    private static void quickSort(int[] array, int low, int high, ArrayList<int[]> intermediateArrays,
            boolean returnIntermediate) {
        if (low < high) {
            int pi = partition(array, low, high);

            if (returnIntermediate)
                intermediateArrays.add(Arrays.copyOf(array, array.length));

            quickSort(array, low, pi - 1, intermediateArrays, returnIntermediate);
            quickSort(array, pi + 1, high, intermediateArrays, returnIntermediate);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}