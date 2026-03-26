class Solution {
    static int mod=1000000007;
    public int countPaths(int n, int[][] roads) {
        ArrayList<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t:roads){
            adj.get(t[0]).add(new int[]{t[1],t[2]});
            adj.get(t[1]).add(new int[]{t[0],t[2]});
        }

        long[] dis=new long[n];
        int[] count=new int[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        Arrays.fill(count,0);
        dis[0]=0;
        count[0]=1;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.add(new long[]{dis[0],0});

        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            long d=curr[0];
            int node=(int) curr[1];
            
            if(d > dis[node]) continue;

            for(int[] neigh : adj.get(node)){
                int nxtNode=neigh[0];
                int wt=neigh[1];

                if(dis[node] + wt < dis[nxtNode]){
                    dis[nxtNode]=dis[node] + wt;

                    count[nxtNode]=count[node];
                    pq.add(new long[]{dis[nxtNode],nxtNode});
                    
                }
                else if(dis[node] + wt == dis[nxtNode]){
                    count[nxtNode] =(int) (count[nxtNode] + count[node] ) % mod;
                }
            }
        }
        return count[n-1];
    }
}