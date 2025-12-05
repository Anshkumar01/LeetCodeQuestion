class Solution {
    public int countPartitions(int[] nums) {
        int count =0;
        int total = 0;
        for(int i=0; i<nums.length; i++){
            total +=nums[i];
        }

        int left = 0;
        for(int i=0; i< nums.length-1; i++){
            left += nums[i];

            if((left - (total-left))%2 ==0){
                count++;
            }
        }
        return count;
    }
}