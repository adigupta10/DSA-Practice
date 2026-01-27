class Solution {
    private boolean dfs(int currNode,List<List<Integer>> adj,boolean[] vis,boolean[] rec,List<Integer> topo){
        vis[currNode]=true;
        rec[currNode]=true;
        for(int neigh : adj.get(currNode)){
            if(!vis[neigh]){
                if(dfs(neigh,adj,vis,rec,topo)) return true;
            }
            else{
                if(rec[neigh]){
                    return true;
                }
            }
        }
        topo.add(currNode);
        rec[currNode]=false;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //dfs and topo sort
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] cell:prerequisites){
            adj.get(cell[1]).add(cell[0]);
        } 
        boolean[] vis=new boolean[numCourses];
        boolean[] rec=new boolean[numCourses];
        List<Integer> topo = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,rec,topo)) return new int[0];
            }
        }
        Collections.reverse(topo);
        int[] ans=new int[numCourses];
        for(int i=0;i<topo.size();i++){
            ans[i]=topo.get(i);
        }
        return ans;
    }
}