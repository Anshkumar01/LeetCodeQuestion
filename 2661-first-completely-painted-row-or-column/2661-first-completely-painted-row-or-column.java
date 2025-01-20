class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] indexMap = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            indexMap[arr[i]] = i;
        }

        int result = arr.length;
        for (int i = 0; i < mat.length; i++) {
            int minIndex = 0;
            for (int j = 0; j < mat[0].length; j++) {
                minIndex = Math.max(minIndex, indexMap[mat[i][j]]);
            }
            result = Math.min(result, minIndex);
        }

        for (int i = 0; i < mat[0].length; i++) {
            int minIndex = 0;
            for (int j = 0; j < mat.length; j++) {
                minIndex = Math.max(minIndex, indexMap[mat[j][i]]);
            }
            result = Math.min(result, minIndex);
        }

        return result;
    }
}