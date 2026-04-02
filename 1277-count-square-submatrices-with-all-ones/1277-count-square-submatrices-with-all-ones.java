class Solution {
    public int countSquares(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int sum=0;
        // last row sum
        for(int i=0;i<m;i++){
            sum+=mat[n-1][i];
        }
       // last col sum
        for(int i=0;i<n;i++){
            sum+=mat[i][m-1];
        }

        // mat[n-1][m-1] do baar count ho rha hai
        sum-=mat[n-1][m-1];
        
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                if(mat[i][j]==1){
                   mat[i][j]=1+Math.min(mat[i][j+1],Math.min(mat[i+1][j+1],mat[i+1][j]));
                    sum+=mat[i][j];
                }
            }
        }
        return sum;
    }
}