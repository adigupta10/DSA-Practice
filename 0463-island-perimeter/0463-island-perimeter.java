class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1) count++;
        }
       } 
       count*=4;
       
       for(int i=0;i<n;i++){
        for(int j=1;j<m;j++){
            if(grid[i][j]==1 && grid[i][j-1]==1) count-=2;
        }
       }
       for(int i=0;i<m;i++){
        for(int j=1;j<n;j++){
            if(grid[j][i]==1 && grid[j-1][i]==1) count-=2;
        }
       }
       return count;
    }
}