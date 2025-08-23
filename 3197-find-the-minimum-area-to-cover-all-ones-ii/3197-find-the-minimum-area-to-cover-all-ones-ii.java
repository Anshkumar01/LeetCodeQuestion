class Solution {
    private int helper(int[][] grid,int n,int m){
        int ans=m*n;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.min(ans,calc(grid,0,i,0,j)+calc(grid,0,i,j+1,m-1)+calc(grid,i+1,n-1,0,m-1));
                ans=Math.min(ans,calc(grid,0,i,0,m-1)+calc(grid,i+1,n-1,0,j)+calc(grid,i+1,n-1,j+1,m-1));
            }
        }
        for(int i=0;i+2<n;i++) for(int j=i+1;j+1<n;j++) ans=Math.min(ans,calc(grid,0,i,0,m-1) +calc(grid,i+1,j,0,m-1)+calc(grid,j+1,n-1,0,m-1));
        return ans;
    }
    public int minimumSum(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] rgrid=rev(grid,n,m);
        return Math.min(helper(grid,n,m),helper(rgrid,m,n));
    }
    private int calc(int[][] grid,int u,int d,int l,int r) {
        int n=grid.length,m=grid[0].length;
        int lMax=0,lMin=n,bMax=0,bMin=m;
        for(int i=u;i<=d;i++){
            for(int j=l;j<=r;j++){
                if(grid[i][j]==1){
                    lMax=Math.max(i+1,lMax);
                    lMin=Math.min(i+1,lMin);
                    bMax=Math.max(j+1,bMax);
                    bMin=Math.min(j+1,bMin);
                }
            }
        }
        return lMin<=lMax?(lMax-lMin+1)*(bMax-bMin+1):Integer.MAX_VALUE/10;
    }
    private int[][] rev(int[][] grid,int n,int m){
        int[][] ans=new int[m][n];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) ans[m-j-1][i]=grid[i][j];
        return ans;
    }
}