class Solution {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) return 0; // Handle edge case for empty input
        
        int maxSum = 0;
        int currSum = nums[0]; // Start with the first element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currSum += nums[i]; // Continue the ascending sum
            } else {
                maxSum = Math.max(maxSum, currSum); // Update maxSum if needed
                currSum = nums[i]; // Reset currSum to the current element
            }
        }

        // Final check to update maxSum with the last ascending sequence
        return Math.max(maxSum, currSum);
    }
}