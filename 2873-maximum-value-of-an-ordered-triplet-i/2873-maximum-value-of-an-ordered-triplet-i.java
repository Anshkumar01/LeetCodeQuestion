class Solution {
    public long maximumTripletValue(int[] nums) {
        int numsSize = nums.length;
        long max = 0;
        for (int i = 0; i < numsSize - 2; i++) {
            for (int j = i + 1; j < numsSize - 1; j++) {
                for (int k = j + 1; k < numsSize; k++) {
                    long temp = (long)(nums[i] - nums[j]) * nums[k];
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
        }
        return max;
        
    }
}