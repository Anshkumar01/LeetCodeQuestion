public class Solution 
{
    public int maximumLength(int[] nums, int k) 
    {
        // Step 1: Prepare a 2D DP table to track remainder transitions
        int[][] dp = new int[k][k]; // dp[prev_rem][curr_rem]
        int maxLength = 0;

        // Step 2: Loop through each number in the array
        for (int num : nums) 
        {
            int current_rem = num % k;

            // Step 3: Try to extend previous sequences
            for (int prev_rem = 0; prev_rem < k; prev_rem++) 
            {
                // Step 4: Update DP table to build longer valid subsequence
                dp[prev_rem][current_rem] = dp[current_rem][prev_rem] + 1;

                // Step 5: Keep track of the maximum length found
                if (dp[prev_rem][current_rem] > maxLength) 
                {
                    maxLength = dp[prev_rem][current_rem];
                }
            }
        }

        // Step 6: Return the final result
        return maxLength;
    }
}