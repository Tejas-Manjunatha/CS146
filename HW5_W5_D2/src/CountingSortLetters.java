import java.util.Arrays;

public class CountingSortLetters {

    public static void sort(char[] input) {
        int n = input.length;
        
        // Step 1: Created a frequency array of size 26
        int[] count = new int[26];
        
        // Step 2: Counted the occurrences of each letter
        for (int i = 0; i < n; i++) {
            count[input[i] - 'A']++;
        }
        
        System.out.println("Frequency Array:");
        printLetterArray(count);

        // Step 3: Converted the frequency array into a cumulative count array
        for (int i = 1; i < 26; i++) {
            count[i] += count[i - 1];
        }
        
        System.out.println("\nCumulative Count Array:");
        printLetterArray(count);

        // Step 4: Used cumulative counts to place each letter in its sorted position
        char[] output = new char[n];
        
        // Iterated backwards to keep original order of duplicates
        for (int i = n - 1; i >= 0; i--) {
            char currentChar = input[i];
            // Found the cumulative count for the character, subtracted 1 for 0-based index
            int position = count[currentChar - 'A'] - 1;
            output[position] = currentChar;
            
            // Decreased the count so the next same character is placed right before it
            count[currentChar - 'A']--;
        }

        // Step 5: Produced the final sorted array
        System.out.println("\nFinal Sorted Array:");
        System.out.println(Arrays.toString(output));
    }

    // Helper method to print the count arrays with corresponding letters
    private static void printLetterArray(int[] array) {
        StringBuilder letters = new StringBuilder("Letter: ");
        StringBuilder values = new StringBuilder("Value:  ");
        
        for (int i = 0; i < 26; i++) {
            // Only print letters that have a count > 0 in the array
            // Or print all 26 shows the exact array structure.
            letters.append(String.format("%3c", (char)(i + 'A')));
            values.append(String.format("%3d", array[i]));
        }
        System.out.println(letters.toString());
        System.out.println(values.toString());
    }

    public static void main(String[] args) {
        char[] input = {'A', 'A', 'Z', 'B', 'H', 'K', 'L', 'Z', 'W', 'X', 'P'};
        
        System.out.println("Original Array");
        System.out.println(Arrays.toString(input) + "\n");
        
        sort(input);
    }
}