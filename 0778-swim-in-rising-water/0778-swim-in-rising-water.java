class Solution {
    
    public int swimInWater(int[][] grid) {
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int n=grid.length;
        boolean[][] vis=new boolean[n][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{grid[0][0],0,0});  // time , i, j

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int time=curr[0];
            int x=curr[1];
            int y=curr[2];

            if(x==n-1 && y==n-1) return time;
            if(vis[x][y]) continue;
            vis[x][y]=true;

            for(int[] d:dir){
                int nx= x + d[0];
                int ny= y + d[1];

                if(nx>=0 && ny>=0 && nx<n && ny<n && !vis[nx][ny]){
                    int maxTime=Math.max(time,grid[nx][ny]);
                    pq.add(new int[]{maxTime,nx,ny});
                }
            }
        }
        return -1; // we will not reach here
    }
}