import java.util.*;

public class ArrayMerger {

    public static void main(String[] args) {
        ArrayMerger merger = new ArrayMerger();

        // 1. Sample sorted arrays
        int[] arrayA = {1, 3, 5, 9};
        int[] arrayB = {2, 4, 6, 7, 8, 10};

        // 2. Perform the merge
        int[] mergedArray = merger.merge(arrayA, arrayB);

        // 3. Print results
        System.out.println("Array A: " + Arrays.toString(arrayA));
        System.out.println("Array B: " + Arrays.toString(arrayB));
        System.out.println("-----------------------------------");
        System.out.println("Merged Result: " + Arrays.toString(mergedArray));
        
        // Check if sorted
        if (isSorted(mergedArray)) {
            System.out.println("Success: The array is correctly sorted!");
        } else {
            System.out.println("Error: The array is not sorted.");
        }
    }

    /**
     * The merge method that merges two sorted arrays into one sorted array
     */
    public int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) return new int[0];

        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) result[k++] = arr1[i++];
        while (j < arr2.length) result[k++] = arr2[j++];

        return result;
    }

    /**
     * Helper method to check if the result is sorted
     */
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }
}
