class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:prerequisites){
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis=new boolean[n];
        boolean[] rec=new boolean[n];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,rec,st)){
                    return new int[]{};
                }
            }
        }
        int[] ans=new int[st.size()];
        int idx=0;
        while(!st.isEmpty()){
            ans[idx++]=st.pop();
        }
        return ans;
    }
    public static boolean dfs(int node,ArrayList<List<Integer>> adj,boolean[] vis,boolean[] rec,Stack<Integer> st){
        vis[node]=true;
        rec[node]=true;
        for(int neigh:adj.get(node)){
            if(!vis[neigh]){
                if(dfs(neigh,adj,vis,rec,st)) return true;
            }
            else if(rec[neigh]) return true;
        }
        rec[node]=false;
        st.push(node);
        return false;
    }
}