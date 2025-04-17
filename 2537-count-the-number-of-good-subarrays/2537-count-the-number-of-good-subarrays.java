class Solution {
    public long countGood(int[] nums, int k) {
        long cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> mpp = new HashMap<>();
            long pairs = 0;
            for (int j = i; j < nums.length; j++) {
                pairs += mpp.getOrDefault(nums[j], 0);
                mpp.put(nums[j], mpp.getOrDefault(nums[j], 0) + 1);
                if (pairs >= k) cnt++;
            }
        }
        return cnt;
    }
}