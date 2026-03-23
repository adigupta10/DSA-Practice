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
// class Solution {

//     public boolean containsCycle(char[][] grid) {

//         int n = grid.length;
//         int m = grid[0].length;

//         boolean[][] vis = new boolean[n][m];

//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < m; j++){

//                 if(!vis[i][j]){
//                     if(bfs(i, j, vis, grid))
//                         return true;
//                 }
//             }
//         }
//         return false;
//     }

//     public boolean bfs(int si, int sj,
//                        boolean[][] vis, char[][] grid){

//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{si, sj, -1, -1});
//         vis[si][sj] = true;

//         while(!q.isEmpty()){

//             int[] cur = q.poll();
//             int i = cur[0];
//             int j = cur[1];
//             int pi = cur[2];
//             int pj = cur[3];

//             // LEFT
//             if(j-1 >= 0 && grid[i][j-1] == grid[i][j]){
//                 if(vis[i][j-1] && !(i == pi && j-1 == pj))
//                     return true;
//                 if(!vis[i][j-1]){
//                     vis[i][j-1] = true;
//                     q.offer(new int[]{i, j-1, i, j});
//                 }
//             }

//             // RIGHT
//             if(j+1 < grid[0].length && grid[i][j+1] == grid[i][j]){
//                 if(vis[i][j+1] && !(i == pi && j+1 == pj))
//                     return true;
//                 if(!vis[i][j+1]){
//                     vis[i][j+1] = true;
//                     q.offer(new int[]{i, j+1, i, j});
//                 }
//             }

//             // UP
//             if(i-1 >= 0 && grid[i-1][j] == grid[i][j]){
//                 if(vis[i-1][j] && !(i-1 == pi && j == pj))
//                     return true;
//                 if(!vis[i-1][j]){
//                     vis[i-1][j] = true;
//                     q.offer(new int[]{i-1, j, i, j});
//                 }
//             }

//             // DOWN
//             if(i+1 < grid.length && grid[i+1][j] == grid[i][j]){
//                 if(vis[i+1][j] && !(i+1 == pi && j == pj))
//                     return true;
//                 if(!vis[i+1][j]){
//                     vis[i+1][j] = true;
//                     q.offer(new int[]{i+1, j, i, j});
//                 }
//             }
//         }

//         return false;
//     }
// }