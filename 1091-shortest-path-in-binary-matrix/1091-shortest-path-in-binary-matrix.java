class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        int[][] dir={{0,-1},{0,1},{-1,0},{1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        boolean[][] vis=new boolean[n][n];
        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{1,0,0}); //dis , row , col
        vis[0][0]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int d=curr[0];
            int r=curr[1];
            int c=curr[2];

            if(r==n-1 && c==n-1 ){
                return d;
            }

            for(int[] di : dir){
                int nr=r+di[0];
                int nc=c+di[1];

                if(nr >=0 && nc>=0  && nr<n && nc<n && !vis[nr][nc] && grid[nr][nc]==0){
                    vis[nr][nc]=true;
                    q.add(new int[]{d+1,nr,nc});
                }
            }
        }
        return -1;
    }
}