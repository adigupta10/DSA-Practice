class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]!=0) return -1;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0,0,0}); // currDis,i,j
        int[][] dis=new int[n][m];
        for(int[] e:dis) Arrays.fill(e,Integer.MAX_VALUE);
        dis[0][0]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int currDis=curr[0];
            int x=curr[1];
            int y=curr[2];

            //if(x==n-1 && y==m-1) return currDis;
            for(int[] di:dir){
                int nx=x+di[0];
                int ny=y+di[1];

                if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==0){
                    if(currDis +1 < dis[nx][ny]){
                        dis[nx][ny]=1+currDis;
                        pq.offer(new int[]{dis[nx][ny],nx,ny});
                    }
                }
            }
        }
        return dis[n-1][m-1] ==Integer.MAX_VALUE ? -1 : dis[n-1][m-1]+1;

    }
}