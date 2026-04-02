class Solution {
    public int minimumArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        //top-most 1
        int topmost1=-1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    topmost1=i;
                    break;
                }
            }
            if(topmost1!=-1) break;
        }

        int bottommost1=-1;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    bottommost1=i;
                    break;
                }
            }
            if(bottommost1!=-1) break;
        }

        int leftmost1=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[j][i]==1){
                    leftmost1=i;
                    break;
                }
            }
            if(leftmost1!=-1) break;
        }
        int rightmost1=-1;
        for(int j=m-1;j>=0;j--){
            for(int i=0;i<n;i++){
                if(grid[i][j]==1){
                    rightmost1=j;
                    break;
                }
            }
            if(rightmost1!=-1) break;
        }
        return (bottommost1-topmost1 + 1) * ( rightmost1-leftmost1 +1);
    }
}