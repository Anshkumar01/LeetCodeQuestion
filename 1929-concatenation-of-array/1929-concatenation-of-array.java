class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];   // create new array of size 2n

        for(int i = 0; i < n; i++) {
            ans[i] = nums[i];       // first half
            ans[i + n] = nums[i];   // second half
        }
        return ans;
    }
}
