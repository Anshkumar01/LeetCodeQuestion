class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        boolean[] attendance = new boolean[n * n + 1];
        int duplicate = -1;

        // Mark occurrences in attendance array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (attendance[grid[i][j]]) {
                    duplicate = grid[i][j];
                } else {
                    attendance[grid[i][j]] = true;
                }
            }
        }

        // Find the missing number
        for (int i = 1; i <= n * n; i++) {
            if (!attendance[i]) return new int[]{duplicate, i};
        }
        return new int[]{};
    }
}