class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] ans=new int[1001];
        for(int[] x:trips){
            int p=x[0];
            int st=x[1];
            int end=x[2];
            ans[st]+=p;
            ans[end]-=p;
        }
        int max=0;
        for(int d:ans){
            max+=d;
            if(max>capacity) return false;
        }
        return true;
    }
}