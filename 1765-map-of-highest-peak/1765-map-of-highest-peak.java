class Solution {
    static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] highestPeak(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){  //saare water ko add kar diya
                    vis[i][j]=true;
                    q.add(new int[]{i,j});
                    grid[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            for(int[] d:dir){
                int nx=x+d[0];
                int ny=y+d[1];

                if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && !vis[nx][ny] && grid[nx][ny]!=1){
                    vis[nx][ny]=true;
                    grid[nx][ny]=1+grid[x][y];
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return grid;
    }
}