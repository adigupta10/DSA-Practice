class Solution {
    private int bfs(int[] dis, List<List<int[]>> adj, int src, int dst, int k){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src,0});  //nodes,weight,stops(levels)
        int stop=0;
        while(!q.isEmpty() && stop<=k){
            int size=q.size();
            while(size-->0){
                int[] cell=q.poll();
                int u=cell[0];
                int cost=cell[1];
                for(int[] edge:adj.get(u)){
                    int v=edge[0];
                    int price=edge[1];
                        if(price+cost<dis[v]){
                        dis[v]=price+cost;
                        q.offer(new int[]{v,dis[v]});
                    }
                }
            }
            stop++;
        }
        return dis[dst]==Integer.MAX_VALUE ?-1 : dis[dst];
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f:flights){
            adj.get(f[0]).add(new int[] {f[1],f[2]});
        }
        int[] dis =new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        int ans=bfs(dis,adj,src,dst,k);
        return ans;
    }
}