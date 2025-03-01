class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int i=0, j=0;
        for( i=0; i<n-1; i++){
            if(nums[i]==nums[i+1]){
                nums[i]=2*nums[i];
                nums[i+1]=0;
            }
            if(nums[i]!=0){
                arr[j++]=nums[i];
            }

        }
        if(nums[i]!=0){
                arr[j++]=nums[i];
            }
            return arr;

    }
}