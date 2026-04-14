class Solution {
    static int n;
    static int m;
    public int swimInWater(int[][] grid) {
        //binary search + dfs-froms src(0,0) to (n-1,m-1)
        n=grid.length;
        m=grid[0].length;
        int left=0;
        int right=n*n-1;
        int ans=n*n;
        while(left<=right){
            int mid=left+(right-left)/2;
            boolean[][] vis=new boolean[n][m];
            if(possibleToReach(0,0,mid,grid,vis)){
                right=mid-1;
                ans=mid;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    public static boolean possibleToReach(int i,int j,int ans,int[][] grid,boolean[][] vis){

        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || grid[i][j]>ans) return false;
        vis[i][j]=true;
        if(i==n-1 && j==m-1) return true;

        boolean down=possibleToReach(i+1,j,ans,grid,vis);
        boolean up=possibleToReach(i-1,j,ans,grid,vis);
        boolean right=possibleToReach(i,j+1,ans,grid,vis);
        boolean left=possibleToReach(i,j-1,ans,grid,vis);

        return down || up || right || left;
    }
}