class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){  // boundary cell
                    if(grid[i][j]==1 && !vis[i][j]){
                        dfs(i,j,grid,vis);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
    public static void dfs(int i,int j, int[][] grid, boolean[][] vis){
        //check for boundary
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j]!=1) return;

         vis[i][j]=true;

         dfs(i+1,j,grid,vis);
         dfs(i-1,j,grid,vis);
         dfs(i,j+1,grid,vis);
         dfs(i,j-1,grid,vis);
        //calling all four directions
    }
}