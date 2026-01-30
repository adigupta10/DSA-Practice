class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        Queue<int[]> q=new LinkedList<>();
        boolean[] vis=new boolean[n];
        q.offer(new int[]{0,0});
        vis[0]=true;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],k-> new ArrayList<>()).add(i);
        }
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int idx=cell[0];
            int steps=cell[1];
            if(idx==n-1) return steps;

            if(idx-1>=0 && !vis[idx-1]){
                q.offer(new int[]{idx-1,steps+1});
                vis[idx-1]=true;
            } 
            if(idx+1<n && !vis[idx+1]){
                q.offer(new int[]{idx+1,steps+1});
                vis[idx+1]=true;
            }
            if(map.containsKey(arr[idx])){
                 for(int next : map.get(arr[idx])){
                    if(!vis[next]){
                        vis[next]=true;
                        q.add(new int[]{next,steps+1});
                    }
               }
               map.remove(arr[idx]);
            }
        }
        return -1;
    }
}