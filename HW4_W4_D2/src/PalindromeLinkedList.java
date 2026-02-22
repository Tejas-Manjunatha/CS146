import java.util.*;

public class PalindromeLinkedList {

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        Node current = head;

        // Step 1: Push all node values onto the stack
        while (current != null) {
            stack.push(current.key);
            current = current.next;
        }

        // Step 2: Reset current to the head of the list
        current = head;

        // Step 3: Pop from stack and compare with the linked list
        while (current != null) {
            int reversedValue = stack.pop(); 
            
            if (current.key != reversedValue) {
                return false; // Mismatch found, not a palindrome
            }
            
            current = current.next;
        }

        return true; 
    }
}