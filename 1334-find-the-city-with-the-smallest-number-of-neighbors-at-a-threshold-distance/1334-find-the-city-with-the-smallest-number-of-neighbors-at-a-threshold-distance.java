class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis=new int[n][n];
        int INF=(int) 1e9;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dis[i][j]=0;
                else dis[i][j]=INF;
            }
        }
        for(int[] e: edges){
            int u=e[0]; int v=e[1]; int w=e[2];
            dis[u][v]=w;
            dis[v][u]=w;
        }
        for(int v=0;v<n;v++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dis[i][j]=Math.min(dis[i][j],dis[i][v]+dis[v][j]);
                }
            }
        }
        int mini=Integer.MAX_VALUE;
        int city=-1;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(i!=j && dis[i][j]<=distanceThreshold) c++;
            }
            if(c<=mini){
                mini=c;
                city=i;
            }
        }
        return city;
    }
}