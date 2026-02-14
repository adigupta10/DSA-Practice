class Solution {
    static double[][] dp;
    public double champagneTower(int k, int i, int j) {
        dp=new double[101][101];
        for(double[] a: dp){
            Arrays.fill(a,-1);
        }
       double ans=Math.min(1.0,solve(k,i,j)); 
       return ans;
    }
    public double solve(int k, int i, int j){
        if(i<0 || j<0 || i<j) return 0.0;
        if(i==0 && j==0) return k;
        //pehle he check kar lo
        if(dp[i][j]!=-1) return dp[i][j];

        double left=(solve(k,i-1,j-1)-1)/2.0;
        double right=(solve(k,i-1,j)-1)/2.0;

        if(left<0) left=0.0;
        if(right<0) right=0.0;

        return dp[i][j]=left+right;
    }
}