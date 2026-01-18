class Solution {
    int n;
    int m;
    private boolean dfs(int i,int j,boolean[][] vis,int[][] grid1 ,int[][] grid2){

        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || grid2[i][j]==0){
            return true;
        }
        boolean isSubIsland= true;
        if(grid2[i][j]==1 && grid1[i][j]==0){
            isSubIsland= false;
        }
        vis[i][j]=true;
        isSubIsland =
                dfs(i + 1, j, vis, grid1, grid2)
                & dfs(i - 1, j, vis, grid1, grid2)
                & dfs(i, j + 1, vis, grid1, grid2)
                & dfs(i, j - 1, vis, grid1, grid2)
                & isSubIsland;
            return isSubIsland;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n=grid2.length;
        m=grid2[0].length;
        boolean[][] vis=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && !vis[i][j]){
                    if(dfs(i,j,vis,grid1,grid2)) count++;
                }
            }
        }
        return count;
    }
}
    