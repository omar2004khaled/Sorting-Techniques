package test.java.org.example;
import main.java.org.example.SortArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class InsertionSortTest {
    /*Tests for insertion sort */ 
    @Test
    public void testInsertionSortSortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.get(0));
    }

    @Test
    public void testInsertionSortReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.get(0));
    }

    @Test
    public void testInsertionSortAllSameElements() {
        int[] array = {7, 7, 7, 7, 7};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{7, 7, 7, 7, 7}, result.get(0));
    }

    @Test
    public void testInsertionSortSingleElement() {
        int[] array = {10};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{10}, result.get(0));
    }

    @Test
    public void testInsertionSortTwoElementsSorted() {
        int[] array = {1, 2};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{1, 2}, result.get(0));
    }

    @Test
    public void testInsertionSortTwoElementsUnsorted() {
        int[] array = {2, 1};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{1, 2}, result.get(0));
    }

    @Test
    public void testInsertionSortLargeNumbers() {
        int[] array = {1000, 500, 2000, 1500, 750};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{500, 750, 1000, 1500, 2000}, result.get(0));
    }

    @Test
    public void testInsertionSortNegativeNumbers() {
        int[] array = {-3, -1, -4, -2, -5};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{-5, -4, -3, -2, -1}, result.get(0));
    }

    @Test
    public void testInsertionSortMixedNumbers() {
        int[] array = {-2, 5, 0, -1, 3};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{-2, -1, 0, 3, 5}, result.get(0));
    }

    @Test
    public void testInsertionSortArrayWithZero() {
        int[] array = {0, -1, 2, -3, 1};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{-3, -1, 0, 1, 2}, result.get(0));
    }

    @Test
    public void testInsertionSortArrayWithDuplicates() {
        int[] array = {4, 2, 2, 1, 4};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{1, 2, 2, 4, 4}, result.get(0));
    }

    @Test
    public void testInsertionSortAlreadySortedArray() {
        int[] array = {10, 20, 30, 40, 50};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{10, 20, 30, 40, 50}, result.get(0));
    }

    @Test
    public void testInsertionSortDescendingArray() {
        int[] array = {9, 8, 7, 6, 5};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{5, 6, 7, 8, 9}, result.get(0));
    }

    @Test
    public void testInsertionSortAlternatingNumbers() {
        int[] array = {3, 1, 4, 2, 5};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.get(0));
    }

    @Test
    public void testInsertionSortLargeArray() {
        int[] array = {50, 40, 30, 20, 10, 0, -10, -20, -30, -40, -50};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{-50, -40, -30, -20, -10, 0, 10, 20, 30, 40, 50}, result.get(0));
    }

    @Test
    public void testInsertionSortArrayContainingMaxMinInteger() {
        int[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE}, result.get(0));
    }

    @Test
    public void testInsertionSortArrayWithOneNegativeAtEnd() {
        int[] array = {3, 1, 2, 4, -5};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{-5, 1, 2, 3, 4}, result.get(0));
    }

    @Test
    public void testInsertionSortEmptyArray() {
        int[] array = {};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{}, result.get(0));
    }

    @Test
    public void testInsertionSortVeryLargeNumbers() {
        int[] array = {1000000000, -1000000000, 500000000, -500000000, 0};
        SortArray sortArray = new SortArray(array);
        long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.simpleSort(false, "InsertionSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
        assertArrayEquals(new int[]{-1000000000, -500000000, 0, 500000000, 1000000000}, result.get(0));
    }
}
