class Solution {
    public long putMarbles(int[] weights, int k) {
        int n=weights.length;
        long[] pairSum=new long[n-1];
        for(int i=0;i<n-1;i++)
        {
            pairSum[i]=weights[i]+weights[i+1];
        }
        Arrays.sort(pairSum);
        int choosePair=k-1;
        long maxSum=0;
        long minSum=0;
        for(int i=0;i<choosePair;i++)
        {
            minSum+=pairSum[i];
            maxSum+=pairSum[pairSum.length-1-i];
        }
        return maxSum-minSum;
    }
}