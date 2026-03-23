class Solution {
    private void dfs(int node ,boolean[] vis, List<List<Integer>> l){
       vis[node]=true;
       for(int neigh:l.get(node)){
        if(!vis[neigh]){
            dfs(neigh,vis,l);
        }
       }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<=n;i++){
            l.add(new ArrayList<>());
        } 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    l.get(i).add(j);
                    l.get(j).add(i);
                }
            }
        }
        boolean[] vis=new boolean[n];
        int ct=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,l);
                ct++;
            }
        }
        return ct;
    }
}