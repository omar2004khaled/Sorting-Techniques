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
    
/*package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        if (returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        ArrayList<Integer> positiveNumbers = new ArrayList<>();

        for (int num : array) {
            if (num < 0) {
                negativeNumbers.add(-num);  
            } else {
                positiveNumbers.add(num);
            }
        }

        
        
        int[] negArr = negativeNumbers.stream().mapToInt(i -> i).toArray();
        int[] posArr = positiveNumbers.stream().mapToInt(i -> i).toArray();

       
        if (negArr.length > 0) 
        {
            radixSort(negArr, returnIntermediate, intermediateArrays);
        }
        if (posArr.length > 0)
        {
            radixSort(posArr, returnIntermediate, intermediateArrays);
        }

        for (int i = 0; i < negArr.length; i++) {
            negArr[i] = -1 * negArr[i];
        }
        reverseArray(negArr);

        int index = 0;
        for (int num : negArr) {
            array[index++] = num;
        }
        for (int num : posArr) {
            array[index++] = num;
        }

        intermediateArrays.add(Arrays.copyOf(array, array.length));

        return intermediateArrays;
    }

    private static void radixSort(int[] array, boolean returnIntermediate, ArrayList<int[]> intermediateArrays) {
        if (array.length == 0) return; 

        int max = Arrays.stream(array).max().orElse(0); 

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);

            if (returnIntermediate)
                intermediateArrays.add(Arrays.copyOf(array, array.length));
        }
    }

    private static void countingSort(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];

        for (int num : array) {
            count[(num / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }

    private static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
*/