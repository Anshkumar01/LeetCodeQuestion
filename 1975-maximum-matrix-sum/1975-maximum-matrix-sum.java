class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;

        int lE = 100001;
        long sum = 0L;
        int negativeCount = 0; 
        for(int[] rows : matrix){
            for(int value:rows){
                if(value<0){
                    negativeCount++;
                    value= -value;
                }

                sum+= value;
                if(value< lE){
                    lE = value;
                }
            }
        }

        return (negativeCount%2 == 0) ? sum : (sum-2*lE);
    }
}