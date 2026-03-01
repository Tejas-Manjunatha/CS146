import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class BSTSearchTest {

    private TreeNode root;

    @BeforeEach
    public void setUp() {
        root = new TreeNode(15);
        
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(13);
        root.left.right.right.left = new TreeNode(9);
        
        root.right = new TreeNode(18);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(20);
    }

    @Test
    public void testSearchExistingKey13() {
        List<Integer> expected = Arrays.asList(15, 6, 7, 13);
        List<Integer> actual = BSTSearch.bstSearchTrace(root, 13);
        assertEquals(expected, actual, "[15, 6, 7, 13]");
    }

    @Test
    public void testSearchMissingKey14() {
        // 14 > 13, so it attempts to go right from 13, hits null, and returns the path so far
        List<Integer> expected = Arrays.asList(15, 6, 7, 13);
        List<Integer> actual = BSTSearch.bstSearchTrace(root, 14);
        assertEquals(expected, actual, "Trace for missing key 14 should stop at 13");
    }

    @Test
    public void testSearchRoot() {
        List<Integer> expected = Arrays.asList(15);
        List<Integer> actual = BSTSearch.bstSearchTrace(root, 15);
        assertEquals(expected, actual, "Trace for root key 15 should be [15]");
    }

    @Test
    public void testSearchExistingKeyLeaf() {
        List<Integer> expected = Arrays.asList(15, 6, 3, 2);
        List<Integer> actual = BSTSearch.bstSearchTrace(root, 2);
        assertEquals(expected, actual, "Trace for 2 should go down the far left path");
    }

    @Test
    public void testSearchMissingKeyHigh() {
        List<Integer> expected = Arrays.asList(15, 18, 20);
        List<Integer> actual = BSTSearch.bstSearchTrace(root, 25);
        assertEquals(expected, actual, "Trace for missing key 25 should stop at 20");
    }
}