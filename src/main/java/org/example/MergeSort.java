package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        if (returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        mergeSort(array, 0, array.length - 1, intermediateArrays, returnIntermediate);

        if (!returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));
        return intermediateArrays;
    }

    private static void mergeSort(int[] array, int left, int right, ArrayList<int[]> intermediateArrays,
            boolean returnIntermediate) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, intermediateArrays, returnIntermediate);
            mergeSort(array, mid + 1, right, intermediateArrays, returnIntermediate);
            merge(array, left, mid, right);

            if (returnIntermediate)
                intermediateArrays.add(Arrays.copyOf(array, array.length));
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            array[i] = temp[k];
        }
    }
}