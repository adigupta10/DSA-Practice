class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] cost =new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0)  cost[0][0]=grid[0][0];
                else{
                    int left=(j>0) ? cost[i][j-1] :  Integer.MAX_VALUE ;
                    int up=(i>0) ? cost[i-1][j] :  Integer.MAX_VALUE ;

                    cost[i][j]=grid[i][j] + Math.min(left,up);
                }
            }
        }
        return cost[n-1][m-1];
    }
}