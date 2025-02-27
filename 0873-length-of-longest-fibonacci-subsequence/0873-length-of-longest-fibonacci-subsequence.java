class Solution {
    public int lenLongestFibSubseq(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], i);
        }
        
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        int res = 0;

        for (int j = 1; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                int prev = nums[j] - nums[i];
                if (mpp.containsKey(prev) && mpp.get(prev) < i) {
                    dp.putIfAbsent(i, new HashMap<>());
                    dp.get(i).put(j, dp.getOrDefault(mpp.get(prev), new HashMap<>()).getOrDefault(i, 0) + 1);
                    res = Math.max(res, dp.get(i).get(j));
                }
            }
        }
        return res > 0 ? res + 2 : 0;
    }
}