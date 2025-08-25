class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        // Edge case
        if (mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }
        
        int m = mat.length, n = mat[0].length; // Row (m) x Column (n)
        int row = 0, col = 0; // Initial starting point
        int index = 0;
        int[] arr = new int[m * n];
        boolean up = true;

        while (index < m * n) {
            arr[index++] = mat[row][col]; // Add current element

            // If moving upward
            if (up) {
                if (col == n - 1) { // Reached the last column
                    row++;
                    up = false;
                } else if (row == 0) { // Reached the first row
                    col++;
                    up = false;
                } else { // Continue moving up
                    row--;
                    col++;
                }
            } 
            // If moving downward
            else {
                if (row == m - 1) { // Reached the last row
                    col++;
                    up = true;
                } else if (col == 0) { // Reached the first column
                    row++;
                    up = true;
                } else { // Continue moving down
                    row++;
                    col--;
                }
            }
        }
        return arr;
    }
}