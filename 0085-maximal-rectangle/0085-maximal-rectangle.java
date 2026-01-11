class Solution {
    private int lr(int[] h){
        Stack<Integer> st = new Stack<>();
        int n = h.length, max = 0;

        for(int i=0;i<=n;i++){
            int cur = (i==n?0:h[i]);
            while(!st.isEmpty()&&h[st.peek()]>cur){
                int height = h[st.pop()];
                int width = st.isEmpty()?i:i-st.peek()-1;
                max = Math.max(max,height*width);
            }
            st.push(i);
        }
        return max;
    }


    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] h = new int[n];
        int ans = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                h[j] = matrix[i][j] =='1' ? h[j]+1:0;

            }
            ans = Math.max(ans, lr(h));
        }
        return ans;
    }
}