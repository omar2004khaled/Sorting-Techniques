package test.java.org.example;
import main.java.org.example.SortArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class RadixSortTest {
 /*Tests for Radix sort */ 
 @Test
 public void testRadixSortSortedArray() {
     int[] array = {1, 2, 3, 4, 5};
     SortArray sortArray = new SortArray(array);
     long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.get(0));
 }

 @Test
 public void testRadixSortReverseSortedArray() {
     int[] array = {5, 4, 3, 2, 1};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.get(0));
 }

 @Test
 public void testRadixSortAllSameElements() {
     int[] array = {7, 7, 7, 7, 7};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{7, 7, 7, 7, 7}, result.get(0));
 }

 @Test
 public void testRadixSortSingleElement() {
     int[] array = {10};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{10}, result.get(0));
 }

 @Test
 public void testRadixSortTwoElementsSorted() {
     int[] array = {1, 2};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{1, 2}, result.get(0));
 }

 @Test
 public void testRadixSortTwoElementsUnsorted() {
     int[] array = {2, 1};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{1, 2}, result.get(0));
 }

 @Test
 public void testRadixSortLargeNumbers() {
     int[] array = {1000, 500, 2000, 1500, 750};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{500, 750, 1000, 1500, 2000}, result.get(0));
 }

 @Test
 public void testRadixSortMixedNumbers() {
     int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{2, 24, 45, 66, 75, 90, 170, 802}, result.get(0));
 }

 @Test
 public void testRadixSortArrayWithZero() {
     int[] array = {0, 5, 3, 1, 4, 2};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, result.get(0));
 }

 @Test
 public void testRadixSortArrayWithDuplicates() {
     int[] array = {4, 2, 2, 1, 4};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{1, 2, 2, 4, 4}, result.get(0));
 }

 @Test
 public void testRadixSortAlreadySortedArray() {
     int[] array = {10, 20, 30, 40, 50};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{10, 20, 30, 40, 50}, result.get(0));
 }

 @Test
 public void testRadixSortLargeArray() {
     int[] array = {1000, 999, 998, 997, 996, 995, 994, 993, 992, 991};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{991, 992, 993, 994, 995, 996, 997, 998, 999, 1000}, result.get(0));
 }



 @Test
 public void testRadixSortVeryLargeNumbers() {
     int[] array = {1000000000, 500000000, 200000000, 700000000, 900000000};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{200000000, 500000000, 700000000, 900000000, 1000000000}, result.get(0));
 }

 @Test
 public void testRadixSortAlternatingNumbers() {
     int[] array = {3, 1, 4, 2, 5};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.get(0));
 }

 @Test
 public void testRadixSortMixedLargeAndSmall() {
     int[] array = {1000, 1, 500, 250, 750};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{1, 250, 500, 750, 1000}, result.get(0));
 }

 @Test
 public void testRadixSortArrayWithRepeatedPatterns() {
     int[] array = {2, 1, 2, 1, 2, 1, 2, 1};
     SortArray sortArray = new SortArray(array);
   long startTime = System.nanoTime();
    ArrayList<int[]> result = sortArray.nonComparisonSort(false, "RadixSort");
    long endTime = System.nanoTime();
    
    long duration = endTime - startTime;
    System.out.println("Execution time: " + duration + " nanoseconds");
     assertArrayEquals(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, result.get(0));
 }
}
