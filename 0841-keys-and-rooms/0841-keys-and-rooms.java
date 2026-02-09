class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis=new boolean[rooms.size()];
        if(isReachable(rooms,0,vis)) return true;
        return false;
    }
    boolean isReachable(List<List<Integer>> rooms, int node,boolean[] vis){
        vis[node]=true;
        for(int neigh : rooms.get(node)){
            if(!vis[neigh]){
                vis[node]=true;
                isReachable(rooms,neigh,vis);
            }
        }
        for(boolean x : vis){
            if(x==false){
                return false;
            }
        }
        return true;
    }
}