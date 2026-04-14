class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        boolean[] vis=new boolean[n];
        int grp=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,stones,vis);
                grp++;
            }
        }
        return n-grp;
    }
    public static void dfs(int i,int[][] stones,boolean[] vis){
        vis[i]=true;
        for(int j=0;j<stones.length;j++){
            if(!vis[j] && (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])){
                dfs(j,stones,vis);
            }
        }
    }
}