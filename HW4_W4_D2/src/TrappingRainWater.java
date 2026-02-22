public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        // Left pointer starting at the beginning
        int left = 0;
        // Right pointer starting at the end
        int right = height.length - 1;
        // Highest block seen from the left
        int leftMax = 0;
        // Highest block seen from the right
        int rightMax = 0;
        // Accumulator for trapped water
        int totalWater = 0;

        // Move pointers inward until they meet
        while (left < right) {
            if (height[left] < height[right]) {
                // The water level is dictated by the left side
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update highest block on the left
                } else {
                    totalWater += leftMax - height[left]; // Calculate and add trapped water
                }
                left++; // Move left pointer forward
            } else {
                // The water level is dictated by the right side
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update highest block on the right
                } else {
                    totalWater += rightMax - height[right]; // Calculate and add trapped water
                }
                right--; // Move right pointer backward
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] elevationMap = {1, 2, 1, 4, 1, 2, 1, 5, 0, 0, 2, 1, 5};
        
        int trappedWater = trap(elevationMap);
        System.out.println("Maximum water trapped: " + trappedWater); 
        // Expected Output: 26
    }
}