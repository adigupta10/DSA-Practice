class Solution {
    public int minimumEffortPath(int[][] height) {
        int n=height.length;
        int m=height[0].length;
        int[][] dis=new int[n][m];

        for(int i=0;i<n;i++){
           Arrays.fill(dis[i],Integer.MAX_VALUE); 
        }

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        dis[0][0]=0;
        q.add(new int[]{0,0,0});
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int effort=curr[0];
            int r=curr[1];
            int c=curr[2];

            if(r==n-1 && c==m-1) return effort;

            if(effort>dis[r][c]){
                continue;
            }

            for(int k=0;k<4;k++){
                int nr= r+ dr[k];
                int nc= c+ dc[k];

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int newEffort=Math.max(effort,Math.abs(height[r][c]-height[nr][nc]));
                    if(newEffort < dis[nr][nc]){
                        dis[nr][nc]=newEffort;
                        q.add(new int[]{newEffort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}