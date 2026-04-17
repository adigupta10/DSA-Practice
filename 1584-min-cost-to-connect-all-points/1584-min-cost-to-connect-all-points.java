class Solution {
    public int minCostConnectPoints(int[][] points) {
        int V=points.length;
        ArrayList<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=i+1;j<V;j++){
                int dis=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                adj.get(i).add(new int[]{j,dis});
                adj.get(j).add(new int[]{i,dis});
            }
        }
        int ans=solve(adj,V);
        return ans;
    }
    public static int solve(ArrayList<List<int[]>> adj,int V){
        boolean[] vis=new boolean[V];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.add(new int[]{0,0});

        int sum=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int wt=curr[1];

           if(vis[node]) continue;
            vis[node]=true;
            sum+=wt;

            for(int[] neigh:adj.get(node)){
                int neighNode=neigh[0];
                int neighWt=neigh[1];
                if(!vis[neighNode]){
                    pq.add(new int[]{neighNode,neighWt});
                }
            }
        }
        return sum;
    }
}