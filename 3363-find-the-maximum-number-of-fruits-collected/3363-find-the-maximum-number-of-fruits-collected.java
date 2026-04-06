class Solution {
    static int n;
    static int[][] dp;
    public int maxCollectedFruits(int[][] fruits) {
        n=fruits.length;
        dp=new int[n][n];
        for(int[] x:dp) Arrays.fill(x,-1);
        int child1=child1(fruits);
        int child2=child2(0,n-1,fruits);
        int child3=child3(n-1,0,fruits);
        return child1+child2+child3;
    }
    public static int child1(int[][] fruits){
        int res=0;
        for(int i=0;i<n;i++){
            res+=fruits[i][i];
        }
        return res;
    }
    public static int child2(int i,int j,int[][] fruits){
        if(i<0 || j<0 || i>=n || j>=n ) return 0;
        if(i==j || j<i) return 0;
        if(i==n-1 && j==n-1) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int downleft=fruits[i][j] +child2(i+1,j-1,fruits);
        int down=fruits[i][j] +child2(i+1,j,fruits);
        int downright=fruits[i][j] +child2(i+1,j+1,fruits);
        return dp[i][j]=Math.max(downleft,Math.max(down,downright));
    }
    public static int child3(int i,int j,int[][] fruits){
        if(i<0 || j<0 || i>=n || j>=n ) return 0;
        if(i==j || j>i) return 0;
        if(i==n-1 && j==n-1) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int forwardright=fruits[i][j] +child3(i-1,j+1,fruits);
        int forward=fruits[i][j] +child3(i,j+1,fruits);
        int forwarddown=fruits[i][j] +child3(i+1,j+1,fruits);
        return dp[i][j]=Math.max(forwardright,Math.max(forward,forwarddown));
    }
}