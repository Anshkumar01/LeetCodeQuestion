class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (nums[j] > 0) {
                    nums[j]--;
                }
            }
        }

        for (int x : nums) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}