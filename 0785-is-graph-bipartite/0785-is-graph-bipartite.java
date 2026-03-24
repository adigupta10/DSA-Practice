class Solution {
    public boolean isBipartite(int[][] arr) {
        Queue<int[]> q=new LinkedList<>();
        int n=arr.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(bfs(q,arr,i,1,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs( Queue<int[]> q,int[][] arr,int node,int currColor,int[] color){
        color[node]=currColor; // red=1  green==0
        q.add(new int[]{node,currColor});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int nd=curr[0];
            int cl=curr[1];
            int newColor=1-cl;
            for(int neigh:arr[nd]){
                if(color[neigh]==cl) return false;
                else if(color[neigh]==-1){
                    color[neigh]=newColor;
                    q.add(new int[]{neigh,newColor});
                }
            }
        }




        // for(int neigh:arr[node]){
        //     if(color[neigh]==currColor){
        //         return false;
        //     }
        //     else if(!vis[neigh] && color[neigh]==-1){
        //         int newColor=1-currColor;
        //         if(dfs(arr,vis,neigh,newColor,color)==false) return false;
        //     }
        // }
        return true;
    }
}