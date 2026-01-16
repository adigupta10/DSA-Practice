class Solution {
    int n;
    int m;
    int area;
    public int maxAreaOfIsland(int[][] grid) {
        int maxi=0;
        n=grid.length;
        m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    area=dfs(i,j,vis,grid);
                    maxi=Math.max(maxi,area);
                    
                }
            }
        }
        return maxi;
    }
    private int dfs(int i,int j,boolean[][] vis,int[][] grid){

        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || grid[i][j]!=1){
            return 0;
        }
        area=1;
        vis[i][j]=true;

        area+=dfs(i+1,j,vis,grid);
        area+=dfs(i-1,j,vis,grid);
        area+=dfs(i,j-1,vis,grid);
        area+=dfs(i,j+1,vis,grid);
        return area;
    }
}
    
