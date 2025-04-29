class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxi = -1;

        for(int i:nums){
            if(i>maxi)
                maxi= i;
        }

        int left = 0;
        int right = 0;
        long ans = 0;
        int c = 0;
        int n = nums.length;

        while(right<n){

            if(nums[right]==maxi){
                c++;
            }
            while(c>=k){
                ans+=n-right;
                if(nums[left]==maxi){
                    c--;
                }
                left++;
            }
            // if(c==k){
            //     int temp = left;
            //     while (temp <= right && nums[temp] != maxi) {
            //         temp++;
            //     }
            //     ans+=temp-left+1;
            // }
            right++;
        } 
        return ans;  
    }
}