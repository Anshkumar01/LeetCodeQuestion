class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        // 1. Pack new values into nums[i]
        for (int i = 0; i < n; i++) {
            nums[i] += n * (nums[nums[i]] % n);
        }
        // 2. Unpack to get the result in-place
        for (int i = 0; i < n; i++) {
            nums[i] /= n;
        }
        return nums;
    }
}