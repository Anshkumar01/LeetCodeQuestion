class Solution {
    public int minDeletionSize(String[] strs) {
        int cols = strs[0].length();
        int rows = strs.length;
        int[] dp = new int[cols];
        for (int i = 0; i < cols; i++){
            dp[i] = 1;
        }
        for (int c = 0; c < cols; c++){
            for (int j = 0; j < c; j++){
                boolean valid = true;
                for (int r = 0; r < rows; r++){
                    if (strs[r].charAt(j) > strs[r].charAt(c)){
                        valid = false;
                        break;
                    }
                }
                if (valid){
                    dp[c] = Math.max(dp[c], dp[j] + 1);
                }
            }
        }
        int maxVal = 0;
        for (int i : dp){
            maxVal = Math.max(maxVal, i);
        }
        return cols - maxVal;
    }
}