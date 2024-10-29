class Solution {
    public int maxMoves(int[][] grid) {
        int maxMoves = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            maxMoves = Math.max(maxMoves, bfs(grid, i));
        }
        return maxMoves<0?0:maxMoves;
    }
    
    private int bfs(int[][] grid, int i){
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{i,0});
         visited[i][0]=true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=1;j<=size;j++){
                int[] temp = q.poll();
                int x = temp[0], y = temp[1];

                if(x-1>=0 && y+1<n && !visited[x-1][y+1] && grid[x-1][y+1]>grid[x][y]){
                    q.add(new int[]{x-1, y+1});
                    visited[x-1][y+1]=true;
                }
                if(y+1<n && !visited[x][y+1] && grid[x][y+1]>grid[x][y]){
                    q.add(new int[]{x, y+1});
                    visited[x][y+1]=true;
                }
                if(x+1<m && y+1<n && !visited[x+1][y+1] && grid[x+1][y+1]>grid[x][y]){
                    q.add(new int[]{x+1, y+1});
                    visited[x+1][y+1]=true;
                }
            }
            count++;
        }
        // System.out.println(count-1);
        return count-1;
    }
}