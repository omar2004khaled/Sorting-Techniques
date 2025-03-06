package test.java;

import main.java.SortArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortArrayTest {
    @Test
    public void testInsertionSort() {
        int[] array = { 5, 3, 1, 4, 2 };
        SortArray sortArray = new SortArray(array);
        int[][] result = sortArray.simpleSort(false);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, result[0]);
    }

    @Test
    public void testMergeSort() {
        int[] array = { 5, 3, 1, 4, 2 };
        SortArray sortArray = new SortArray(array);
        int[][] result = sortArray.efficientSort(false);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, result[0]);
    }

    @Test
    public void testRadixSort() {
        int[] array = { 170, 45, 75, 90, 802, 24, 2, 66 };
        SortArray sortArray = new SortArray(array);
        int[][] result = sortArray.nonComparisonSort(false);
        assertArrayEquals(new int[] { 2, 24, 45, 66, 75, 90, 170, 802 }, result[0]);
    }
}