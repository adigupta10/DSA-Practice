class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                int down = grid[i+1][j];
                int left = (j > 0) ? grid[i+1][j-1] : Integer.MAX_VALUE;
                int right = (j < n-1) ? grid[i+1][j+1] : Integer.MAX_VALUE;
                grid[i][j] += Math.min(down, Math.min(left, right));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            ans = Math.min(ans, grid[0][j]);
        }
        return ans;
    }
}