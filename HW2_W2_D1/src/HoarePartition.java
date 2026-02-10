public class HoarePartition {

    /**
     * Hoare's Partition
     * The first element is the pivot
     *
     * @param arr  The array to be partitioned
     * @param low  The starting index (i)
     * @param high The ending index (j)
     * @return The split index
     */
    public static int partition(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) {
            return -1;
        }

        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // Find leftmost element greater than or equal to pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Find rightmost element smaller than or equal to pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // If two pointers meet
            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}