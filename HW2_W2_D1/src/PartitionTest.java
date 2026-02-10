import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class PartitionTest {
    //Lomuto
    @Test
    public void testLomutoSortedArray() {
        int[] arr = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
        int low = 0;
        int high = arr.length - 1;

        // In Lomuto, pivot is arr[high] (67)
        int partitionIndex = LomutoPartition.partition(arr, low, high);

        System.out.println("Lomuto Sorted: " + Arrays.toString(arr));
        
        // Verifying Lomuto property:
        // All elements left of partitionIndex should be <= arr[partitionIndex]
        // All elements right of partitionIndex should be >= arr[partitionIndex]
        verifyLomutoPartition(arr, partitionIndex, low, high);
    }

    @Test
    public void testLomutoUnsortedArray() {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};
        int low = 0;
        int high = arr.length - 1;

        int partitionIndex = LomutoPartition.partition(arr, low, high);
        
        System.out.println("Lomuto Unsorted: " + Arrays.toString(arr));
        
        verifyLomutoPartition(arr, partitionIndex, low, high);
    }

    //Hoare
    @Test
    public void testHoareSortedArray() {
        int[] arr = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
        int low = 0;
        int high = arr.length - 1;
        int pivotValue = arr[low];

        int partitionIndex = HoarePartition.partition(arr, low, high);

        System.out.println("Hoare Sorted: " + Arrays.toString(arr));

        // Verify Hoare property:
        // arr[low..p] <= pivot
        // arr[p+1..high] >= pivot
        verifyHoarePartition(arr, partitionIndex, low, high, pivotValue);
    }

    @Test
    public void testHoareUnsortedArray() {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};
        int low = 0;
        int high = arr.length - 1;
        int pivotValue = arr[low];

        int partitionIndex = HoarePartition.partition(arr, low, high);

        System.out.println("Hoare Unsorted: " + Arrays.toString(arr));

        verifyHoarePartition(arr, partitionIndex, low, high, pivotValue);
    }

    //Empty Arrays
    @Test
    public void testLomutoEmptyArray() {
        int[] arr = {};
        // Standard partition is called with 0 and length-1.
        // For empty array, length-1 is -1.
        int result = LomutoPartition.partition(arr, 0, -1);
        
        // This implementation returns -1 for invalid ranges/empty arrays
        Assertions.assertEquals(-1, result, "Should return -1 for empty array");
    }

    @Test
    public void testHoareEmptyArray() {
        int[] arr = {};
        int result = HoarePartition.partition(arr, 0, -1);
        
        //This implementation returns -1 for invalid ranges/empty arrays
        Assertions.assertEquals(-1, result, "Should return -1 for empty array");
    }

    //VERIFICATION METHODS
    private void verifyLomutoPartition(int[] arr, int pIndex, int low, int high) {
        int pivotValue = arr[pIndex];

        // Checking left side
        for (int i = low; i < pIndex; i++) {
            Assertions.assertTrue(arr[i] <= pivotValue, 
                "Lomuto: Element at " + i + " (" + arr[i] + ") is > pivot " + pivotValue);
        }
        // Checkiung right side
        for (int i = pIndex + 1; i <= high; i++) {
            Assertions.assertTrue(arr[i] >= pivotValue, 
                "Lomuto: Element at " + i + " (" + arr[i] + ") is < pivot " + pivotValue);
        }
    }

    private void verifyHoarePartition(int[] arr, int pIndex, int low, int high, int pivotValue) {
        // Hoare splits the array into two parts based on the pivot value.
        // Left side [low...pIndex] <= pivot
        for (int i = low; i <= pIndex; i++) {
            Assertions.assertTrue(arr[i] <= pivotValue, 
                "Hoare: Left element at " + i + " (" + arr[i] + ") is > pivot " + pivotValue);
        }

        // Right side [pIndex+1...high] >= pivot
        for (int i = pIndex + 1; i <= high; i++) {
            Assertions.assertTrue(arr[i] >= pivotValue, 
                "Hoare: Right element at " + i + " (" + arr[i] + ") is < pivot " + pivotValue);
        }
    }
}