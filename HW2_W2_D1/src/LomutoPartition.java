public class LomutoPartition {

    /**
     * Lomuto's Partition
     * The last element is the pivot
     *
     * @param arr  The array to be partitioned
     * @param low  The starting index
     * @param high The ending index
     * @return The partition index
     */
    public static int partition(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) {
            return -1;
        }

        int pivot = arr[high]; // Pivot
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        swap(arr, i + 1, high);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}