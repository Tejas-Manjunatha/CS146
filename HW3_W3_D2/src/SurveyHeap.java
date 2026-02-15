import java.util.*;

class WordFreq {
    String word;
    int frequency;

    public WordFreq(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "[" + word + ": " + frequency + "]";
    }
}

public class SurveyHeap {
    public static void main(String[] args) {
        // Creating the array
        WordFreq[] surveyData = {
            new WordFreq("happy", 400),
            new WordFreq("satisfied", 100),
            new WordFreq("neutral", 300),
            new WordFreq("would buy again", 200),
            new WordFreq("terrible", 160),
            new WordFreq("inconvenient", 900),
            new WordFreq("difficult to use", 100),
            new WordFreq("easy to use", 140),
            new WordFreq("would recommend to friends", 800),
            new WordFreq("visit the store", 700)
        };
        
        // Printing the incomplete array
        System.out.println("--- Original Array ---");
        printArray(surveyData);

        // Building the max heap
        buildMaxHeap(surveyData);

        // Printing the completed array
        System.out.println("\n--- Max Heap Array ---");
        printArray(surveyData);
    }

    public static void buildMaxHeap(WordFreq[] arr) {
        int n = arr.length;
        // Starting from the last non-leaf node and moving up to root node
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    // Ensures the subtree rooted at index 'i' is a valid max heap
    public static void maxHeapify(WordFreq[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child exists and is greater than root
        if (left < n && arr[left].frequency > arr[largest].frequency) {
            largest = left;
        }

        // Check if right child exists and is greater than the current largest
        if (right < n && arr[right].frequency > arr[largest].frequency) {
            largest = right;
        }

        // If largest is not root, swap and continue sinking down
        if (largest != i) {
            WordFreq swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the impacted sub-tree
            maxHeapify(arr, n, largest);
        }
    }

    // Printing the array clean and not messy
    public static void printArray(WordFreq[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }
    }
}