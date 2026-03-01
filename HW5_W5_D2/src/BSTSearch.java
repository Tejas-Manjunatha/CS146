import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTSearch {

    public static List<Integer> bstSearchTrace(TreeNode root, Integer k) {
        // Base case: If reach a null node, return an empty list
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> trace;

        // If current node matches the key, initialize the list
        // Do not recurse further because we found target
        if (root.val == k) {
            trace = new LinkedList<>();
        } 
        // If the key is less than current node's value, search left
        else if (k < root.val) {
            trace = bstSearchTrace(root.left, k);
        } 
        // If the key is greater than current node's value, search right
        else {
            trace = bstSearchTrace(root.right, k);
        }

        // Prepend the current node's value to the list returned by the child call
        // Index 0 inserts it at front
        trace.add(0, root.val);
        
        return trace;
    }
}