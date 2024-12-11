class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if(nums.length==1)
            return 1;
        
        int mb =0;
        int mv=0;
        for(int num:nums)
            mv=Math.max(mv,num);
        
        int[] count = new int[mv+1];

        for(int num:nums){
            count[Math.max(num-k, 0)]++;
            count[Math.min(num+k+1, mv)]--;
        }
        int cs=0;
        for(int val:count){
            cs+=val;
            mb = Math.max(mb, cs);
        }
        return mb;
    }
}