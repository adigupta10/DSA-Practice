class Solution {
    public boolean isBipartite(int[][] arr) {
        int n=arr.length;
        boolean[] vis=new boolean[n];
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(arr,vis,i,1,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs( int[][] arr,boolean[] vis,int node,int currColor,int[] color){
        vis[node]=true;
        color[node]=currColor; // red=1  green==0
        for(int neigh:arr[node]){
            if(color[neigh]==currColor){
                return false;
            }
            else if(!vis[neigh] && color[neigh]==-1){
                int newColor=1-currColor;
                if(dfs(arr,vis,neigh,newColor,color)==false) return false;
            }
        }
        return true;
    }
}