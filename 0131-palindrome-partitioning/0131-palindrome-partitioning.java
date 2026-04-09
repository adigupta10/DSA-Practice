class Solution {
    static int n;
    static boolean[][] dp;
    public List<List<String>> partition(String s) {
        n=s.length();
        dp=new boolean[n][n];
        for(boolean[] x:dp) Arrays.fill(x,false);
        ArrayList<List<String>> ans=new ArrayList<>();
        ArrayList<String> curr=new ArrayList<>();
        solve(0,curr,ans,s);
        return ans;
    }

    public static void solve(int idx, ArrayList<String> curr, ArrayList<List<String>> ans,String s){
        if(idx>=n){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<n;i++){
            if(pal(idx,i,s)){
                curr.add(s.substring(idx,i+1));   //do
                solve(i+1,curr,ans,s);   //explore
                curr.remove(curr.size()-1);   //undo
            }
        }
    }
    public static boolean pal(int left,int right,String s){
        if(left>right) return true;
        if(dp[left][right]!=false) return dp[left][right];
        if(s.charAt(left)==s.charAt(right)){
            return pal(left+1,right-1,s);
        }
        return dp[left][right]=false;
    }
}