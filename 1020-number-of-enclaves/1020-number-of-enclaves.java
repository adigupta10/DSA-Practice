class Solution {
    public int numEnclaves(int[][] grid) {
        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][m];
        //row
        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && !vis[i][0]){
                q.offer(new int[]{i,0});
                vis[i][0]=true;
            }
            if(grid[i][m-1]==1 && !vis[i][m-1]){
                q.offer(new int[]{i,m-1});
                vis[i][m-1]=true;
            }
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && !vis[0][j]){
                q.offer(new int[]{0,j});
                vis[0][j]=true;
            }
            if(grid[n-1][j]==1 && !vis[n-1][j]){
                q.offer(new int[]{n-1,j});
                vis[n-1][j]=true;
            }
        }
        int[][] direction={{0,1},{-1,0},{0,-1},{1,0}};
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int r=cell[0];
            int c=cell[1];
            for(int[] dir:direction){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]==1){
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                    
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==false) count++;
            }
        }
        return count;
    }
}