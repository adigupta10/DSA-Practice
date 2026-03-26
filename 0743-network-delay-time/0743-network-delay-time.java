class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t:times){
            adj.get(t[0]).add(new int[]{t[1],t[2]});
        }
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{dis[k],k});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int d=curr[0];
            int node=curr[1];

            for(int[] neigh : adj.get(node)){
                int nxtNode=neigh[0];
                int wt=neigh[1];

                if(dis[node] + wt < dis[nxtNode]){
                    dis[nxtNode]=dis[node] + wt;

                    pq.add(new int[]{dis[nxtNode],nxtNode});
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            ans=Math.max(ans,dis[i]);
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}