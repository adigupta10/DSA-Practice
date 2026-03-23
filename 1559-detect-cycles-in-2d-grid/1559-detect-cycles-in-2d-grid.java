class Solution {
    static int[][] dir={{1,0},{0,1},{0,-1},{-1,0}};
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    if(dfs(i,j,-1,-1,vis,grid)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i,int j,int px,int py,boolean[][] vis,char[][] grid){
        vis[i][j]=true;

        for(int[] d:dir){
            int nx=i+d[0];
            int ny=j+d[1];

            if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length) continue;
            if(grid[nx][ny]!=grid[i][j]) continue;

            if(vis[nx][ny]){
               if (! (nx==px && ny==py)) return true;
            }
            else {
                if(dfs(nx,ny,i,j,vis,grid)) return true;
            }
        }
        return false;
    }
}