class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Queue<Integer> q=new LinkedList<>();
        boolean[] arr=new boolean[n];
        // make adj list
        ArrayList<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x:invocations){
            int u=x[0];
            int v=x[1];
            adj.get(u).add(v);
        }
        //make all the suspicious node
        q.offer(k);
        arr[k]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int neigh:adj.get(curr)){
                if(!arr[neigh]){
                    arr[neigh]=true;
                    q.offer(neigh);
                }
            }
        }
        //if any non-suspicious invokes a suspicious node
        ArrayList<Integer> ans=new ArrayList<>();
        for(int[] edge:invocations){
            int u=edge[0];
            int v=edge[1];
            for(int neigh:adj.get(u)){
                if(!arr[u] && arr[v]){
                    for(int i=0;i<n;i++){
                        ans.add(i);
                    }
                    return ans;
                }
            }
        }
        // return the non-suspicious node
        for(int i=0;i<n;i++){
            if(!arr[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}