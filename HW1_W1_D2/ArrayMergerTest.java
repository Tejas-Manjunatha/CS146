import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class ArrayMergerTest {

    ArrayMerger merger = new ArrayMerger();

    @Test
    public void testStandardMerge() {
        // Regular test
        int[] arr1 = {1, 3, 5, 9};
        int[] arr2 = {2, 4, 6, 7, 8, 10};
        
        int[] result = merger.merge(arr1, arr2);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertArrayEquals("The arrays should be merged in sorted order", expected, result);
    }

    @Test
    public void testOneEmptyArray() {
        // Testing for 1 empty array
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {};
        
        int[] result = merger.merge(arr1, arr2);
        
        assertArrayEquals("Merging with an empty array should return the non-empty array", arr1, result);
    }

    @Test
    public void testBothEmptyArrays() {
        //Testing for empty arrays
        int[] result = merger.merge(new int[]{}, new int[]{});
        
        assertEquals("Merging two empty arrays should result in an empty array", 0, result.length);
    }

    @Test
    public void testNullInput() {
        // Testing for null inputs
        int[] result = merger.merge(null, new int[]{1, 2});
        
        assertNotNull("Result should not be null", result);
        assertEquals("Your code is designed to return empty array if inputs are null", 0, result.length);
    }

    @Test
    public void testDuplicates() {
        // Testing for duplicate numbers
        int[] arr1 = {1, 2, 2};
        int[] arr2 = {2, 3};
        
        int[] result = merger.merge(arr1, arr2);
        int[] expected = {1, 2, 2, 2, 3};
        
        assertArrayEquals("Should handle duplicates correctly", expected, result);
    }

    @Test
    public void testDisjointArrays() {
        // Testing when all elements of one array are smaller than the other
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {8, 9, 10};
        
        int[] result = merger.merge(arr1, arr2);
        int[] expected = {1, 2, 3, 8, 9, 10};
        
        assertArrayEquals("Should handle arrays where one is entirely smaller than the other", expected, result);
    }
}
