class Node {
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
        this.next = null;
    }
}

public class SinglyLinkedList {

    // Inserts node x at the head and returns the new head
    public static Node listInsert(Node head, Node x) {
        x.next = head;
        return x; 
    }

    // Returns the node whose key matches k, or null if not found
    public static Node listSearch(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null; // Key not found in the list
    }

    // Deletes node x from the list and returns the updated head
    public static Node listDelete(Node head, Node x) {
        // Edge case: Empty list or null node passed
        if (head == null || x == null) {
            return head;
        }
        
        // Case 1: The node to be deleted is the head node
        if (head == x) {
            return head.next;
        }
        
        // Case 2: The node is somewhere else in the list
        Node current = head;
        while (current.next != null && current.next != x) {
            current = current.next;
        }
        
        // If we found the node immediately preceding 'x', bypass 'x'
        if (current.next == x) {
            current.next = x.next;
        }
        
        return head;
    }

    // Method to display the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.key + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;

        // Create individual nodes
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);

        // Insert at least three nodes
        System.out.println("Inserting 10, 20, and 30");
        head = listInsert(head, node1);
        head = listInsert(head, node2);
        head = listInsert(head, node3);

        // Print the list
        System.out.print("Current List: ");
        printList(head); 

        // Search for a node
        int searchKey = 20;
        Node foundNode = listSearch(head, searchKey);
        
        if (foundNode != null) {
            System.out.println("Success: Node with key " + searchKey + " was found!");
        } else {
            System.out.println("Failure: Node with key " + searchKey + " was not found.");
        }

        // Delete one of the nodes (passing the object reference directly)
        head = listDelete(head, node2);

        // Print the list again to show the change
        System.out.print("Updated List: ");
        printList(head);
    }
}